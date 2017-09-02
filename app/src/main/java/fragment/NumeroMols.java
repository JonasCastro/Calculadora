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


public class NumeroMols extends Fragment {

    private Button bntIgualdade;
    private Button btnLimpar;
    private EditText edTxtMassa;
    private EditText edTxtNMols;
    private EditText edTxtMassaM;

    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_nmols, container, false);
        bntIgualdade = (Button) view.findViewById(R.id.fmNM_btnIgualdade);
        btnLimpar = (Button) view.findViewById(R.id.fmNM_btnLimpar);

        edTxtNMols = (EditText) view.findViewById(R.id.fmNM_editTextNMols);
        edTxtMassa = (EditText) view.findViewById(R.id.fmNM_editTextMassa);
        edTxtMassaM = (EditText) view.findViewById(R.id.fmNM_editTextMassaM);


        bntIgualdade.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Double result = 0.0;
                if(!edTxtMassa.getText().toString().isEmpty() && !edTxtMassaM.getText().toString().isEmpty()) {

                    Double massa = Double.parseDouble(edTxtMassa.getText().toString());
                    Double massaM = Double.parseDouble(edTxtMassaM.getText().toString());
                    result = (massa / massaM);
                    edTxtNMols.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else if(!edTxtNMols.getText().toString().isEmpty() && edTxtMassa.getText().toString().isEmpty() && !edTxtMassaM.getText().toString().isEmpty()) {

                    Double nMols = Double.parseDouble(edTxtNMols.getText().toString());
                    Double massaM = Double.parseDouble(edTxtMassaM.getText().toString());
                    result = (nMols * massaM);
                    edTxtMassa.setText(String.format("%.2f" ,result).replace(",","."));

                }
                else if(!edTxtNMols.getText().toString().isEmpty() && !edTxtMassa.getText().toString().isEmpty() && edTxtMassaM.getText().toString().isEmpty()) {
                    Double massa = Double.parseDouble(edTxtMassa.getText().toString());
                    Double nMols = Double.parseDouble(edTxtNMols.getText().toString());
                    result = (massa / nMols);
                    edTxtMassaM.setText(String.format("%.2f" ,result).replace(",","."));
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(),"Forneça dois Valores.",Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edTxtNMols.setText("");
                edTxtMassa.setText("");
                edTxtMassaM.setText("");
            }
        });

    // Inflate the layout for this fragment
    return view;
}
}
