package com.example.proyectomoviles;

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
    private RecyclerView Iscrecycle;

    private List<iscmodel> iscmodelList;
    private iscadapter iscAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Inicializar Firebase Firestore
        firestore = FirebaseFirestore.getInstance();

        // Obtener una referencia al RecyclerView desde el diseño
        Iscrecycle = root.findViewById(R.id.iscrrec);

        // Configurar el administrador de diseño para el RecyclerView (vertical en este caso)
        Iscrecycle.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inicializar la lista de modelos
        iscmodelList = new ArrayList<>();

        // Inicializar el adaptador del RecyclerView
        iscAdapter = new iscadapter(getActivity(), iscmodelList);

        // Establecer el adaptador en el RecyclerView
        Iscrecycle.setAdapter(iscAdapter);

        // Consultar la colección "Iscbook" en Firestore
        firestore.collection("Iscbook").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    // Obtener datos de Firestore y crear un objeto IscModel
                    iscmodel iscModel = new iscmodel(

                            document.getString("imageUrl"),
                            document.getString("name"),
                            document.getString("description"),
                            document.getDouble("price"),
                            document.getString("type"),
                            document.getDouble("gananciaTotal")
                    );
                    iscmodelList.add(iscModel);
                }
                // Notificar al adaptador que los datos han cambiado
                iscAdapter.notifyDataSetChanged();
            } else {
                Log.e("FirestoreError", "Error al obtener documentos", task.getException());
            }
        });

        return root;
    }
}
