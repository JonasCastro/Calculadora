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
    private EditText layoutCL_edTxtMolaridade,layoutCL_edTxtNMols,layoutCL_edTxtVolume,layoutCL_edTxtMassa,layoutCL_edTxtMassaM;
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

        layoutCL_edTxtMolaridade = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMolaridade);
        layoutCL_edTxtNMols = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextNMols);
        layoutCL_edTxtVolume = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextVolume);
        layoutCL_edTxtMassa = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMassa);
        layoutCL_edTxtMassaM = (EditText) view.findViewById(R.id.fmML_layoutCalcnMols_editTextMassaM);

        layoutCL_btnLimpar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutCL_edTxtMolaridade.setText("");
                layoutCL_edTxtNMols.setText("");
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

                    layoutFornecNmols.setClickable(false);
                    layoutFn_edTxtMolaridade.setClickable(false);
                    layoutFn_edTxtNMols.setClickable(false);
                    layoutFn_edTxtVolume.setClickable(false);
                    layoutFn_btnIgualdade.setClickable(false);
                    layoutFn_btnLimpar.setClickable(false);

                    layoutCalcNmols.setClickable(true);
                    layoutCL_edTxtMolaridade.setClickable(true);
                    layoutCL_edTxtNMols.setClickable(true);
                    layoutCL_edTxtVolume.setClickable(true);
                    layoutCL_edTxtMassa.setClickable(true);
                    layoutCL_edTxtMassaM.setClickable(true);
//                    layoutCL_btnIgualdade.setClickable(true);
//                    layoutCL_btnLimpar.setClickable(true);

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

                    layoutCalcNmols.setClickable(false);
                    layoutCL_edTxtMolaridade.setClickable(false);
                    layoutCL_edTxtNMols.setClickable(false);
                    layoutCL_edTxtVolume.setClickable(false);
                    layoutCL_edTxtMassa.setClickable(false);
                    layoutCL_edTxtMassaM.setClickable(false);
//                    layoutCL_btnIgualdade.setClickable(false);
//                    layoutCL_btnLimpar.setClickable(false);

                    layoutFornecNmols.setClickable(true);
                    layoutFn_edTxtMolaridade.setClickable(true);
                    layoutFn_edTxtNMols.setClickable(true);
                    layoutFn_edTxtVolume.setClickable(true);
                    layoutFn_btnIgualdade.setClickable(true);
                    layoutFn_btnLimpar.setClickable(true);

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
