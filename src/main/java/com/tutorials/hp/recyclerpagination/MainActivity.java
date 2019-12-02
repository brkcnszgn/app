package com.tutorials.hp.recyclerpagination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.tutorials.hp.recyclerpagination.mPager.Paginator;
import com.tutorials.hp.recyclerpagination.mRecycler.MyAdapter;
import com.tutorials.hp.recyclerpagination.mRecycler.NameModel;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Button nextBtn, prevBtn;
    // Buraya simdi bir liste gonderecez
    private Paginator p;
    private int totalPages = 0; // Bu total page neyi neye bolmustu bakam bi toplam sayfayı  7 ye perpage işte o zaman bu
    private int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<NameModel> nameModelList = new ArrayList<>();

        for(int i = 0; i< 100; i++){
            nameModelList.add(new NameModel("Adı"+i,"Soyadı"+i));
        }

        // Önce bir statik deneyelim
        p = new Paginator(nameModelList.size(),7,nameModelList);
        // denedin mi evet çalıştı indis olayını göz ardı etmişi :D adı 0 dan başlıyordu :D ama onceden nasıl calıstı neyse
        // Bundan sonra sen yaparsın dıgerıne adapte et teşekkür ederim ^^ hadı gorusuruz görüşürz sağolasın
        totalPages = p.getRemaining(); // calısıyor şımdı burada dınamık yapılacak sen yapar mısın yoksa?
        //benim kafamn almadığı şey şu hala bu adam paginator da for sayı üretiyor heh orayı ıste sımdı dınamık yapalım  bır sınıf yapmamız lazım
        // Bu adam string yapmıs bız baska sınıf yapalım tamam yazayım hızlı adı soyıda dıye tmmdır düzeltt niye 100 degil :D heh bende tam onu dicektim


        //RFERENCE VIEWS
        rv = (RecyclerView) findViewById(R.id.rv);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        prevBtn.setEnabled(false);

        //RECYCLER PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(this));

        //ADAPTER
        rv.setAdapter(new MyAdapter(MainActivity.this, p.generatePage(currentPage)));

        //NAVIGATE
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentPage += 1;
                // enableDisableButtons();
                rv.setAdapter(new MyAdapter(MainActivity.this, p.generatePage(currentPage)));
              //  toggleButtons();

            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

                rv.setAdapter(new MyAdapter(MainActivity.this, p.generatePage(currentPage)));

               // toggleButtons();
            }
        });
    }
/// private void toggleButtons() {
//        if (currentPage == totalPages) {
//            nextBtn.setEnabled(false);
//            prevBtn.setEnabled(true);
//        } else if (currentPage == 0) {
//            prevBtn.setEnabled(false);
//            nextBtn.setEnabled(true);
//        } else if (currentPage >= 1 && currentPage <= totalPages) {
//            nextBtn.setEnabled(true);
//            prevBtn.setEnabled(true); asdasdasd :D patladık bide iyi mi : D // bu

//        }
//    }
}
