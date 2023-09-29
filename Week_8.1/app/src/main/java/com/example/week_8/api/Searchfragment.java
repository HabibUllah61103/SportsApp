package com.example.week_8.api;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week_8.R;
import com.example.week_8.modelClass;
import com.example.week_8.searchAdapter;

import java.util.ArrayList;


public class Searchfragment extends Fragment {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<modelClass> arrayList = new ArrayList<>();
    ArrayList<modelClass> searchList;
    String[] searchItems = new String[]{
            "R.O. T-shirt", "Blue Jersey", "Thin Line T-shirt",
            "Sports Jersey", "Yellow T-shirt", "Blue and White Jersey",
            "Cricket Event Tuesday", "Football Event Monday", "BasketBall Event Friday",
            "Tennis Match Event", "Volleyball Match"
    };
    String[] searchNum = new String[]{
            "Blue, Orange, White Combination", "Dark Blue Dotted Jersey", "Orange, Blue Thin Lined",
            "Mehroom, Red Jersey", "Yellow shirt With Blue Border", "Blue Shirt With White Contrast",
            "Tuesday 10AM in Milan", "Monday Final Match 4PM", "Group Stage Friday Match",
            "Tuesday 11AM in Jardin des", "Saturday 2PM in SouthWark"
    };

    String[] searchdetails = new String[]{
            "The R.O. T-shirt is a trendy top made of a comfortable cotton blend. It features a unique blue, orange, and white combination that stands out in any crowd. Ideal for casual outings or everyday wear.",
            "This dark blue dotted jersey is perfect for sports enthusiasts. Made of lightweight material, it's comfortable and allows for breathability. The dotted pattern adds a touch of style.",
            "An elegant t-shirt designed with thin orange and blue lines. This shirt pairs well with jeans or shorts, making it versatile for both semi-formal and casual occasions.",
            "The sports jersey in a mehroom and red combination is suitable for various sports activities. It's made of a material that wicks sweat away, ensuring you stay dry and comfortable during your game.",
            "A vibrant yellow t-shirt with a blue border. Made of 100% cotton, it's soft to the touch and perfect for summers. The blue border adds a touch of elegance.",
            "This jersey showcases a beautiful contrast of blue with white. It's designed for athletes and sports lovers, ensuring comfort during rigorous activities.",
            "Join us for an exciting cricket match this Tuesday at 10 AM in Milan. Witness top teams compete for the championship title. Bring your enthusiasm!",
            "The Monday final match at 4 PM is expected to be a game-changer. Top football teams will be clashing for the trophy. Don't miss the action!",
            "The group stage matches for basketball will be held this Friday. See your favorite teams battle it out on the court and aim for the finals.",
            "A grand tennis match awaits you this Tuesday at 11 AM in Jardin des. Watch skilled players deliver powerful serves and returns.",
            "Volleyball lovers are in for a treat this Saturday at 2 PM in SouthWark. Experience the thrill as teams spike their way to victory."
    };
    int[] imgList =new int[]{R.drawable.jersey3, R.drawable.jersey2, R.drawable.jersey1,
            R.drawable.scroll2_img3, R.drawable.scroll2_img2, R.drawable.scroll2_img1,R.drawable.local1, R.drawable.local2,
            R.drawable.local3, R.drawable.local4, R.drawable.local5
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_searchfragment, container, false);

        searchView = rootView.findViewById(R.id.search_bar);
        recyclerView = rootView.findViewById(R.id.recyclerview);

        for (int i = 0; i < searchItems.length; i++){
            modelClass modelClass = new modelClass();
            modelClass.setSearchItemName(searchItems[i]);
            modelClass.setSearchItemNum(searchNum[i]);
            modelClass.setSearchDetail(searchdetails[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        searchAdapter searchAdapter = new searchAdapter(getContext(), arrayList);
        recyclerView.setAdapter(searchAdapter);

        searchView .setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();


                if (query.length()>0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getSearchItemName().toLowerCase().contains(query.toLowerCase())){
                            modelClass modelClass = new modelClass();
                            modelClass.setSearchItemName(arrayList.get(i).getSearchItemName());
                            modelClass.setSearchItemNum(arrayList.get(i).getSearchItemNum());
                            modelClass.setSearchDetail(arrayList.get(i).getSearchDetail());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    searchAdapter searchAdapter = new searchAdapter(getContext(), searchList);
                    recyclerView.setAdapter(searchAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    searchAdapter searchAdapter = new searchAdapter(getContext(), arrayList);
                    recyclerView.setAdapter(searchAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();

                if (newText.length()>0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getSearchItemName().toLowerCase().contains(newText.toLowerCase())){
                            modelClass modelClass = new modelClass();
                            modelClass.setSearchItemName(arrayList.get(i).getSearchItemName());
                            modelClass.setSearchItemNum(arrayList.get(i).getSearchItemNum());
                            modelClass.setSearchDetail(arrayList.get(i).getSearchDetail());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    searchAdapter searchAdapter = new searchAdapter(getContext(), searchList);
                    recyclerView.setAdapter(searchAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    searchAdapter searchAdapter = new searchAdapter(getContext(), arrayList);
                    recyclerView.setAdapter(searchAdapter);
                }
                return false;
            }
        });
        return rootView;
    }
}


