package id.ac.umy.tugasakhir;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import id.ac.umy.tugasakhir.ui.home.HomeFragment;

public class RecyclerViewAdapterPasien extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataPasien> listDataPasien;
    private Context context;
    private FragmentManager manager;

    public RecyclerViewAdapterPasien(ArrayList<DataPasien> listDataPasien){
        this.listDataPasien = listDataPasien;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Nama, JenisK, Usia, Alamat;
        private LinearLayout ListItem;

        ViewHolder(View itemView){
            super(itemView);
            Nama = itemView.findViewById(R.id.namaP);
            JenisK = itemView.findViewById(R.id.jenisKP);
            Usia = itemView.findViewById(R.id.usiaP);
            Alamat = itemView.findViewById(R.id.alamatP);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        ViewHolder listView = (ViewHolder) holder;
        final String Nama = listDataPasien.get(position).getNama();
        final String JenisK = listDataPasien.get(position).getJenisK();
        final String Usia = listDataPasien.get(position).getUsia();
        final String Alamat = listDataPasien.get(position).getAlamat();

        listView.Nama.setText("Nama : "+ Nama);
        listView.JenisK.setText("Jenis Kelamin : "+ JenisK);
        listView.Usia.setText("Usia : "+ Usia);
        listView.Alamat.setText("Alamat : "+ Alamat);

        listView.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final String[] action = {"Update", "Delete"};
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setItems(action, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                break;
                            case 1:

                                listener.onDeleteData(listDataPasien.get(position), position);
                                break;
                        }
                    }
                });
                alert.create();
                alert.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDataPasien.size();
    }

    public interface dataListener{
        void onDeleteData (DataPasien data, int position);
    }

    dataListener listener;

    public RecyclerViewAdapterPasien (ArrayList listDataPasien, Context context){

        this.listDataPasien = listDataPasien;
        this.context = context;
        listener = (ListDataPasien)context;
    }
}
