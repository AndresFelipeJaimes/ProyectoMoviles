package com.example.proyectomoviles;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FirebaseFirestore firestore;
    private RecyclerView iscRecyclerView;
    private List<iscmodel> iscModelList;
    private IscAdapter iscAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Inicializar Firebase Firestore
        firestore = FirebaseFirestore.getInstance();

        // Obtener una referencia al RecyclerView desde el diseño
        //iscRecyclerView = root.findViewById(R.id.isc);

        // Configurar el administrador de diseño para el RecyclerView (horizontal en este caso)
        iscRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        // Inicializar la lista de modelos
        iscModelList = new ArrayList<>();

        // Inicializar el adaptador del RecyclerView
        iscAdapter = new IscAdapter(getActivity(), iscModelList);

        // Establecer el adaptador en el RecyclerView
        iscRecyclerView.setAdapter(iscAdapter);

        // Consultar la colección "Iscbook" en Firestore
        firestore.collection("Iscbook").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    // Obtener datos de Firestore y crear un objeto IscModel
                    iscmodel iscModel = new iscmodel(
                            document.getString("name"),
                            document.getString("description"),
                            document.getDouble("price"),
                            document.getString("imageUrl"),
                            document.getDouble("gananciaTotal");
                    );
                    iscModelList.add(iscmodel);
                }
                // Notificar al adaptador que los datos han cambiado
                iscAdapter.notifyDataSetChanged();
            } else {
                Log.w(TAG, "Error getting documents", task.getException());
            }
        });

        return root;
    }
}
