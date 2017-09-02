package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonas.calculadora.R;


public class Concentracao extends Fragment {

    private Button bntIgualdade;
    private Button btnClear;
    private EditText edTxtConcentracao;
    private EditText edTxtMassa;
    private EditText edTxtVolume;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_concentracao, container, false);

        bntIgualdade = (Button) view.findViewById(R.id.fmCT_btnIgualdade);
        btnClear = (Button) view.findViewById(R.id.fmCT_btnLimpar);

        edTxtConcentracao = (EditText) view.findViewById(R.id.fmCT_editTxtConcentracao);
        edTxtMassa = (EditText) view.findViewById(R.id.fmCT_editTxtMassa);
        edTxtVolume = (EditText) view.findViewById(R.id.fmCT_editTxtVolume);


        bntIgualdade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              Double result = 0.0;
                if(!edTxtMassa.getText().toString().isEmpty() && !edTxtVolume.getText().toString().isEmpty()) {

                    Double massa = Double.parseDouble(edTxtMassa.getText().toString());
                    Double volume = Double.parseDouble(edTxtVolume.getText().toString());
                    result = (massa / volume);
                    edTxtConcentracao.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else if(!edTxtConcentracao.getText().toString().isEmpty() && edTxtMassa.getText().toString().isEmpty() && !edTxtVolume.getText().toString().isEmpty()) {

                    Double concentracao = Double.parseDouble(edTxtConcentracao.getText().toString());
                    Double volume = Double.parseDouble(edTxtVolume.getText().toString());
                    result = (concentracao * volume);
                    edTxtMassa.setText(String.format("%.2f" ,result).replace(",","."));

                }
                else if(!edTxtConcentracao.getText().toString().isEmpty() && !edTxtMassa.getText().toString().isEmpty() && edTxtVolume.getText().toString().isEmpty()) {
                    Double massa = Double.parseDouble(edTxtMassa.getText().toString());
                    Double concentracao = Double.parseDouble(edTxtConcentracao.getText().toString());
                    result = (massa / concentracao);
                    edTxtVolume.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),"Forneça dois Valores.",Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edTxtConcentracao.setText("");
                edTxtMassa.setText("");
                edTxtVolume.setText("");
            }
        });


        // Inflate the layout for this fragment
        return view;
    }


}
