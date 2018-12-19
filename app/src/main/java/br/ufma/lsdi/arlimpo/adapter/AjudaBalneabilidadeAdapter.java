package br.ufma.lsdi.arlimpo.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import br.ufma.lsdi.arlimpo.R;
import br.ufma.lsdi.arlimpo.domain.auxiliar.CapabilityDataAuxiliar;
import br.ufma.lsdi.arlimpo.util.DateUtil;


/**
 * Created by Leeo on 25/10/2016.
 */

public class AjudaBalneabilidadeAdapter extends RecyclerView.Adapter<AjudaBalneabilidadeAdapter.DetalheDadosGraficoViewHolder> {

    private LayoutInflater mLayoutInflater;
    final Dialog dialog;
    private final Context context;
    private static final String TAG = "DetalheDadosGeraisAdapter";
    private List<CapabilityDataAuxiliar> capabilityDataAuxiliars;

    public AjudaBalneabilidadeAdapter(Context context, Set<CapabilityDataAuxiliar> dataAuxiliars) {
        this.capabilityDataAuxiliars = new ArrayList<>();
        this.capabilityDataAuxiliars.addAll(dataAuxiliars);
        this.context = context;
        dialog = new Dialog(context);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public DetalheDadosGraficoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_ajuda_balneabilidade, parent, false);
        DetalheDadosGraficoViewHolder mvh = new DetalheDadosGraficoViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(final DetalheDadosGraficoViewHolder holder, final int position) {

        holder.data.setText(capabilityDataAuxiliars.get(position).getValue());
        if (capabilityDataAuxiliars.get(position).getValue().equals("PROPRIO")) {
            holder.valor.setText("Praias apropriadas para banho");
        }else{
            holder.valor.setText("Praias não apropriadas para banho");
            holder.imageView.setImageResource(R.mipmap.red_marker);

        }
    }

    @Override
    public int getItemCount() {
        return capabilityDataAuxiliars.size();
    }

    public static class DetalheDadosGraficoViewHolder extends RecyclerView.ViewHolder {
        private TextView data;
        private TextView valor;
        private ImageView imageView;

        public DetalheDadosGraficoViewHolder(final View itemView) {
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.cardtitle);
            valor = (TextView) itemView.findViewById(R.id.tv_situacao);
            imageView = (ImageView) itemView.findViewById(R.id.cardimage);
        }
    }

}
