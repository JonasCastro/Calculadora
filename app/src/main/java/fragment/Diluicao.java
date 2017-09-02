package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jonas.calculadora.R;


public class Diluicao extends Fragment {

    private Button bntIgualdade;
    private Button btnClear;
    private EditText edTxtConcentracao;
    private EditText edTxtMassa;
    private EditText edTxtVolume;
//    private TextView lblConcentracao;
//    private TextView lblMassa;
//    private TextView lblVolume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diluicao, container, false);




        // Inflate the layout for this fragment
        return view;
    }


}
