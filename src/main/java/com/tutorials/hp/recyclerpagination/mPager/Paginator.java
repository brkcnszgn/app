package com.tutorials.hp.recyclerpagination.mPager;

import com.tutorials.hp.recyclerpagination.mRecycler.NameModel;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Paginator {
    //burda kendisi size vermiş bende onu list.size olarak verdim aynı şey yanibişi bişi dicem biz bu işlemleri adapterin içinde yapsak komple ? oradaki listi kullansak
    // olmaz mı
    // bakıyorum şımdı bu statıc degerlerı kaldırmak lazım once burayı bır dınamık yapalım gerısını sen halledersın bence
    private  int numItem;
    private int perPage;
    private  int remaining;
    private int lastPage;
    java.util.List<NameModel> list;

    public Paginator(int numItem, int perPage, List<NameModel> list) {
        this.numItem = numItem;
        this.perPage = perPage;
        this.remaining = numItem % perPage;
        this.lastPage = numItem /perPage;
        this.list = list;// Bu degil mi evet surdaki hesaplamaları doğru mu yaptık ısımler saglamından su degerlerı kontrol edelım sayı bitince durması lazım
    }


    public ArrayList<NameModel> generatePage(int currentPage)
    {
        int startItem=currentPage*this.perPage+1; // dogru mu yazdim sen de bak bkaıyom :D
        int numOfData=this.perPage;
        ArrayList<NameModel> pageData=new ArrayList<>();

        if (currentPage==this.lastPage && this.perPage>0) // gercı oyle olsa statıktede patlardı ama liste 100 tane 98 den sonra tekrar 2 tane basmalıydı :D crasha dönüyor
        {
            for (int i=startItem;i<startItem+this.remaining;i++) // seyleri kontrol etmek lazım ısımlerı karıstı neyse sendeyiz ^^ telde denim bakakim ne çıkcak hata
            {
                pageData.add(list.get(i-1)); // su forda patlıyor muhtemelen evet orda // su ustte +1 varya ondan mı acaba
            }
        }else
        {
            for (int i=startItem;i<startItem+numOfData;i++) // Buraları ozellikle
            {
                pageData.add(list.get(i-1)); // bak diyo ki index 105 size 'an 100 ama sımdı arttı demekki lazım :D buraya -1 dediysen diğer tarafya +1 almalııyz ^^
            }
        }
        return pageData;
    }



    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getRemaining() {
        return remaining;
    }
}
