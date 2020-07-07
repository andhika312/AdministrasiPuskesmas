package id.ac.umy.tugasakhir.ui.pendaftaran;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.ac.umy.tugasakhir.DataPasien;
import id.ac.umy.tugasakhir.R;
import id.ac.umy.tugasakhir.ui.home.HomeFragment;

public class PendaftaranFragment extends Fragment {

    private PendaftaranViewModel pendaftaranViewModel;
    private Button daftar;
    private EditText nama;
    private EditText jenisK;
    private EditText usia;
    private EditText alamat;
    private FirebaseAuth auth;
    DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pendaftaranViewModel =
                ViewModelProviders.of(this).get(PendaftaranViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pendaftaran, container, false);
        /*final TextView textView = root.findViewById(R.id.text_gallery);
        pendaftaranViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        daftar = root.findViewById(R.id.btn_Daftar);
        nama = root.findViewById(R.id.et_NamaL);
        jenisK = root.findViewById(R.id.et_JenisK);
        usia = root.findViewById(R.id.et_Usia);
        alamat = root.findViewById(R.id.et_Alamat);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String namaL  = nama.getText().toString();
                //final String getUserID = auth.getUid();
                String jenisKL = jenisK.getText().toString();
                String usiaL = usia.getText().toString();
                String alamatL = alamat.getText().toString();

                if (TextUtils.isEmpty(namaL) || TextUtils.isEmpty(jenisKL) || TextUtils.isEmpty(usiaL) || TextUtils.isEmpty(alamatL)){
                    Toast.makeText(getContext(), "Data Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
                } else {
                    databaseReference.child("Pasien").push().setValue(new DataPasien(namaL, jenisKL,usiaL, alamatL)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            nama.setText("");
                            jenisK.setText("");
                            usia.setText("");
                            alamat.setText("");
                            Toast.makeText(getContext(), "Data Berhasil Di Masukan!", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        return root;

    }
}