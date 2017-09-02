package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.media.RatingCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.WindowCompat;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.jonas.calculadora.R;

import java.time.format.TextStyle;


public class Calculadora extends Fragment {

private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;
    private  View custom_tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Calculadora");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);
        View conteiner = (View) container.getParent();
        appBar = (AppBarLayout) conteiner.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);


//        TextView tabText =(TextView)tabOne.findViewById(R.id.tabText);
//        tabText.setText("Molaridade");
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);


        appBar.addView(tabs);
        viewPager=(ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter =  new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabs.setupWithViewPager(viewPager);
        custom_tab();
        return view;
    }
    @Override
    public void onDestroyView(){

        super.onDestroyView();
        appBar.removeView(tabs);
    }

    public class  ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
    String[] titulosTabs = {"Concentração\nComum","Molaridade","Número de\n Mols","Diluição"};

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new Concentracao();
                case 1: return new Molaridade();
                case 2: return new NumeroMols();
                case 3: return new Diluicao();


            }
            return null;
        }

        @Override
        public int getCount() {

            return 4;
        }

    }
    private void custom_tab(){
//        custom_tab = (View) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        String[] titulosTabs = {"Concentração\nComum","Molaridade","Número de\n Mols","Diluição"};
        for (int i = 0; i < titulosTabs.length; i++){
            custom_tab = (View) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
            ((TextView)custom_tab.findViewById(R.id.tabText)).setText(titulosTabs[i]);
            tabs.getTabAt(i).setCustomView(custom_tab);
        }


    }



}
