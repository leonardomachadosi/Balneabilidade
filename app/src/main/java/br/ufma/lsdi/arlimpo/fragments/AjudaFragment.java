package br.ufma.lsdi.arlimpo.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufma.lsdi.arlimpo.R;
import br.ufma.lsdi.arlimpo.activity.MainActivity;
import br.ufma.lsdi.arlimpo.adapter.AjudaBalneabilidadeAdapter;
import br.ufma.lsdi.arlimpo.adapter.DetalheDadosGraficoAdapter;
import br.ufma.lsdi.arlimpo.domain.auxiliar.CapabilityAuxiliar;
import br.ufma.lsdi.arlimpo.domain.auxiliar.CapabilityDataAuxiliar;

/**
 * Created by Leeo on 04/04/2017.
 */

public class AjudaFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public Context context;

    private final String PREFS_PRIVATE = "PREFS_PRIVATE";
    private SharedPreferences sharedPreferences;

    private RecyclerView mRecyclerViewChart;
    private LinearLayoutManager mLayoutManagerChart;
    private RecyclerView.Adapter mAdapterChart;

    private Set<CapabilityDataAuxiliar> capabilityDataAuxiliars;


    public static AjudaFragment newInstance(String param1, String param2) {
        AjudaFragment fragment = new AjudaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AjudaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.toolbar.setTitle("Ajuda");
        capabilityDataAuxiliars = new HashSet<>();
        gerarDadosBalneabilidade();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ajuda, container, false);
        sharedPreferences = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        mRecyclerViewChart = (RecyclerView) view.findViewById(R.id.rv_lista_dados_balneabilidade);
        return view;
    }

    public void gerarDadosBalneabilidade() {
        CapabilityDataAuxiliar dataAuxiliar = new CapabilityDataAuxiliar();
        dataAuxiliar.setTimestamp("");
        dataAuxiliar.setValue("PROPRIO");
        capabilityDataAuxiliars.add(dataAuxiliar);

        CapabilityDataAuxiliar dataAuxiliar2 = new CapabilityDataAuxiliar();
        dataAuxiliar2.setTimestamp(null);
        dataAuxiliar2.setValue("IMPROPRIO");
        capabilityDataAuxiliars.add(dataAuxiliar2);

        mLayoutManagerChart = new LinearLayoutManager(context);
        mRecyclerViewChart.setHasFixedSize(true);
        mRecyclerViewChart.setLayoutManager(mLayoutManagerChart);
        mRecyclerViewChart.setItemAnimator(new DefaultItemAnimator());
        mAdapterChart = new AjudaBalneabilidadeAdapter(context, capabilityDataAuxiliars);
        mRecyclerViewChart.setAdapter(mAdapterChart);
    }

}
