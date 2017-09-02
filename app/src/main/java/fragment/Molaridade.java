package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonas.calculadora.R;

import static android.view.View.*;


public class Molaridade extends Fragment {

    private Button layoutCL_btnIgualdade,layoutCL_btnLimpar,layoutFn_btnIgualdade,layoutFn_btnLimpar;
    private EditText layoutCL_edTxtMolaridade,layoutCL_edTxtVolume,layoutCL_edTxtMassa,layoutCL_edTxtMassaM;
    private EditText layoutFn_edTxtMolaridade,layoutFn_edTxtNMols,layoutFn_edTxtVolume;
    private FloatingActionButton fab_menu,fab_calc,fab_fornec;
    private ConstraintLayout layoutFornecNmols,layoutCalcNmols;
    private TextView fab_lblCalc,fab_lblFornec;
    private boolean isFabOpen = false , isLayoutCalOpen = true;
    private Animation fabOpen,fabClose,rotateForward,rotateBackward;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_molaridade, container, false);
        buildFab(view);

        buildLayoutFornecerNmols(view);
        buildLayoutCalcularNmols(view);
        // Inflate the layout for this fragment
        return view;
    }



    private void buildLayoutCalcularNmols(View view){

        layoutCL_btnLimpar = (Button) view.findViewById(R.id.fmML_layoutCalcnMols_btnLimpar);
        layoutCL_btnIgualdade= (Button) view.findViewById(R.id.fmML_layoutCalcnMols_btnIgualdade);

        layoutCL_edTxtMolaridade = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMolaridade);
        layoutCL_edTxtVolume = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextVolume);
        layoutCL_edTxtMassa = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMassa);
        layoutCL_edTxtMassaM = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMassaM);

        layoutCL_btnIgualdade.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result ;
                if(!layoutCL_edTxtVolume.getText().toString().isEmpty() && !layoutCL_edTxtMassa.getText().toString().isEmpty() && !layoutCL_edTxtMassaM.getText().toString().isEmpty()) {

                    Double volume = Double.parseDouble(layoutCL_edTxtVolume.getText().toString());
                    Double massa = Double.parseDouble(layoutCL_edTxtMassa.getText().toString());
                    Double massaM = Double.parseDouble(layoutCL_edTxtMassaM.getText().toString());

                    result = massa/(massaM*volume);
                    layoutCL_edTxtMolaridade.setText(String.format("%.2f" ,result).replace(",","."));
                }

                else if(!layoutCL_edTxtMolaridade.getText().toString().isEmpty() && layoutCL_edTxtVolume.getText().toString().isEmpty() && !layoutCL_edTxtMassa.getText().toString().isEmpty() && !layoutCL_edTxtMassaM.getText().toString().isEmpty()) {

                    Double molaridade = Double.parseDouble(layoutCL_edTxtMolaridade.getText().toString());
                    Double massa = Double.parseDouble(layoutCL_edTxtMassa.getText().toString());
                    Double massaM = Double.parseDouble(layoutCL_edTxtMassaM.getText().toString());

                    result = massa/(molaridade*massaM);
                    layoutCL_edTxtVolume.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else if(!layoutCL_edTxtMolaridade.getText().toString().isEmpty() && !layoutCL_edTxtVolume.getText().toString().isEmpty() && layoutCL_edTxtMassa.getText().toString().isEmpty() && !layoutCL_edTxtMassaM.getText().toString().isEmpty()) {

                    Double molaridade = Double.parseDouble(layoutCL_edTxtMolaridade.getText().toString());
                    Double volume = Double.parseDouble(layoutCL_edTxtVolume.getText().toString());
                    Double massaM = Double.parseDouble(layoutCL_edTxtMassaM.getText().toString());

                    result = massaM*molaridade*volume;
                    layoutCL_edTxtMassa.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else if(!layoutCL_edTxtMolaridade.getText().toString().isEmpty() && !layoutCL_edTxtVolume.getText().toString().isEmpty() && !layoutCL_edTxtMassa.getText().toString().isEmpty() && layoutCL_edTxtMassaM.getText().toString().isEmpty()) {

                    Double molaridade = Double.parseDouble(layoutCL_edTxtMolaridade.getText().toString());
                    Double volume = Double.parseDouble(layoutCL_edTxtVolume.getText().toString());
                    Double massa = Double.parseDouble(layoutCL_edTxtMassa.getText().toString());

                    result = massa/(molaridade*volume);
                    layoutCL_edTxtMassaM.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),"Forneça Três Valores.",Toast.LENGTH_SHORT).show();
                }


            }
        });
        layoutCL_btnLimpar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutCL_edTxtMolaridade.setText("");
                layoutCL_edTxtVolume.setText("");
                layoutCL_edTxtMassa.setText("");
                layoutCL_edTxtMassaM.setText("");
            }
        });


    }


    private void buildLayoutFornecerNmols(View view){


        layoutFn_btnIgualdade = (Button) view.findViewById(R.id.fmML__layoutFnMols_btnIgualdade);
        layoutFn_btnLimpar = (Button) view.findViewById(R.id.fmML_layoutFnMols_btnLimpar);

        layoutFn_edTxtMolaridade = (EditText) view.findViewById(R.id.fmML_layoutFnMols_editTextMolaridade);
        layoutFn_edTxtNMols = (EditText) view.findViewById(R.id.fmML_layoutFnMols_editTextNMols);
        layoutFn_edTxtVolume = (EditText) view.findViewById(R.id.fmML_layoutFnMols_editTextVolume);


        layoutFn_btnIgualdade.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result ;
                if(!layoutFn_edTxtNMols.getText().toString().isEmpty() && !layoutFn_edTxtVolume.getText().toString().isEmpty()) {

                    Double nMols = Double.parseDouble(layoutFn_edTxtNMols.getText().toString());
                    Double volume = Double.parseDouble(layoutFn_edTxtVolume.getText().toString());

                    result = (nMols / volume);
                    layoutFn_edTxtMolaridade.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else if(!layoutFn_edTxtMolaridade.getText().toString().isEmpty() && layoutFn_edTxtNMols.getText().toString().isEmpty() && !layoutFn_edTxtVolume.getText().toString().isEmpty()) {

                    Double molaridade = Double.parseDouble(layoutFn_edTxtMolaridade.getText().toString());
                    Double volume = Double.parseDouble(layoutFn_edTxtVolume.getText().toString());
                    result = (molaridade * volume);
                    layoutFn_edTxtNMols.setText(String.format("%.2f" ,result).replace(",","."));

                }
                else if(!layoutFn_edTxtMolaridade.getText().toString().isEmpty() && !layoutFn_edTxtNMols.getText().toString().isEmpty() && layoutFn_edTxtVolume.getText().toString().isEmpty()) {
                    Double nMols = Double.parseDouble(layoutFn_edTxtNMols.getText().toString());
                    Double molaridade = Double.parseDouble(layoutFn_edTxtMolaridade.getText().toString());
                    result = (nMols / molaridade);
                    layoutFn_edTxtVolume.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),"Forneça dois Valores.",Toast.LENGTH_SHORT).show();
                }


            }
        });
        layoutFn_btnLimpar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutFn_edTxtMolaridade.setText("");
                layoutFn_edTxtNMols.setText("");
                layoutFn_edTxtVolume.setText("");
            }
        });


        }

    private void buildFab(View view){
        fab_menu = (FloatingActionButton) view.findViewById(R.id.fmML_layout_fab_menu);
        fab_calc = (FloatingActionButton) view.findViewById(R.id.fmML_layout_fab_itemCalc);
        fab_fornec = (FloatingActionButton) view.findViewById(R.id.fmML_layout_fab_itemFornc);

        fabOpen = AnimationUtils.loadAnimation(getContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getContext(),R.anim.fab_close);

        rotateForward =AnimationUtils.loadAnimation(getContext(),R.anim.rotate_forward);
        rotateBackward =AnimationUtils.loadAnimation(getContext(),R.anim.rotate_backward);
        fab_lblCalc = (TextView) view.findViewById(R.id.fmML_layout_fab_lblCalc);
        fab_lblFornec = (TextView) view.findViewById(R.id.fmML_layout_fab_lblFornc);

        layoutCalcNmols = view.findViewById(R.id.fmML_layoutCalcNmols);
        layoutFornecNmols  = view.findViewById(R.id.fmML_layoutFornecNmols);

        fab_menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();

            }
        });

        fab_calc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();

                if(!isLayoutCalOpen) {
                    layoutFornecNmols.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.layout_molaridade_close));
                    layoutCalcNmols.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.layout_molaridade_open));

                    layoutFornecNmols.setVisibility(INVISIBLE);

                    layoutFn_edTxtMolaridade.setVisibility(INVISIBLE);
                    layoutFn_edTxtNMols.setVisibility(INVISIBLE);
                    layoutFn_edTxtVolume.setVisibility(INVISIBLE);
                    layoutFn_btnIgualdade.setVisibility(INVISIBLE);
                    layoutFn_btnLimpar.setVisibility(INVISIBLE);

                    layoutCalcNmols.setVisibility(VISIBLE);

                    layoutCL_edTxtMolaridade.setVisibility(VISIBLE);
                    layoutCL_edTxtVolume.setVisibility(VISIBLE);
                    layoutCL_edTxtMassa.setVisibility(VISIBLE);
                    layoutCL_edTxtMassaM.setVisibility(VISIBLE);
                    layoutCL_btnIgualdade.setVisibility(VISIBLE);
                    layoutCL_btnLimpar.setVisibility(VISIBLE);




                    isLayoutCalOpen = true;
                }
//
            }
        });

        fab_fornec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if(isLayoutCalOpen) {
                    layoutCalcNmols.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.layout_molaridade_close));
                    layoutFornecNmols.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.layout_molaridade_open));

                    layoutCalcNmols.setVisibility(INVISIBLE);

                    layoutCL_edTxtMolaridade.setVisibility(INVISIBLE);
                    layoutCL_edTxtVolume.setVisibility(INVISIBLE);
                    layoutCL_edTxtMassa.setVisibility(INVISIBLE);
                    layoutCL_edTxtMassaM.setVisibility(INVISIBLE);
                    layoutCL_btnIgualdade.setVisibility(INVISIBLE);
                    layoutCL_btnLimpar.setVisibility(INVISIBLE);

                    layoutFornecNmols.setVisibility(VISIBLE);

                    layoutFn_edTxtMolaridade.setVisibility(VISIBLE);
                    layoutFn_edTxtNMols.setVisibility(VISIBLE);
                    layoutFn_edTxtVolume.setVisibility(VISIBLE);
                    layoutFn_btnIgualdade.setVisibility(VISIBLE);
                    layoutFn_btnLimpar.setVisibility(VISIBLE);


                    isLayoutCalOpen = false;
                }
            }
        });




    }

    private void animateFab(){
        if(isFabOpen){
            fab_menu.startAnimation(rotateForward);
            fab_calc.startAnimation(fabClose);
            fab_fornec.startAnimation(fabClose);
            fab_calc.setClickable(false);
            fab_fornec.setClickable(false);
            fab_lblFornec.startAnimation(fabClose);
            fab_lblCalc.startAnimation(fabClose);
            isFabOpen = false;
        }
        else{

            fab_menu.startAnimation(rotateBackward);
            fab_calc.startAnimation(fabOpen);
            fab_fornec.startAnimation(fabOpen);
            fab_fornec.startAnimation(fabOpen);
            fab_calc.setClickable(true);
            fab_fornec.setClickable(true);
            fab_lblFornec.startAnimation(fabOpen);
            fab_lblCalc.startAnimation(fabOpen);
            isFabOpen = true;
        }

    }
}
