package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Inicializa las variables
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asignacion de varible
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.idView);


        //inicializa array
        ArrayList<String> arraylist = new ArrayList<>();
        //titulos del tab
        arraylist.add("Tab 1");
        arraylist.add("Tab 2");
        arraylist.add("Tab 3");
        arraylist.add("Tab ");


        //inflamos el viewPager
        prepareViewPager(viewPager,arraylist);
        //configuramos con view Pager
        tabLayout.setupWithViewPager(viewPager);

    }
    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList){
        //inicializa el main adapter
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        //inicializamos el main fragment
        MainFragment mainFragment = new MainFragment();
        for(int i=0;i<arrayList.size();i++){
            //inicia bundle
            Bundle bundle = new Bundle();
            //envia el string
            bundle.putString("key",arrayList.get(i));
            //se muestra el titulo
            mainFragment.setArguments(bundle);
            //se agregga el fragmento
            adapter.addFragment(mainFragment,arrayList.get(i));
            mainFragment= new MainFragment();
        }
        viewPager.setAdapter(adapter);

    }

    private class MainAdapter extends FragmentPagerAdapter {

        //inicializa array
        ArrayList<String> arraylist = new ArrayList<>();
        List<Fragment>  fragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment,String title){
            //agregamos titulo
            arraylist.add(title);
            //agregamos fragmento
            fragmentList.add(fragment);
        }
        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            //retornado  la posicion del fragmento para la vista
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //regresamos la posicion del arrayList
            return  arraylist.get(position);
        }
    }
}