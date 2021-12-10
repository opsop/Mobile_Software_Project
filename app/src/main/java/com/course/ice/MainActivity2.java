package com.course.ice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView myRecyclerView;

    ImageView i1, i2, i3, i4;
    String search;
    SearchView searchView;

    Fragment fragment0, fragment1, fragment2, fragment3;

    ArrayList<Shoes> shoesInfo = new ArrayList<>();
    ArrayList<Shoes> adidas = new ArrayList<>();
    ArrayList<Shoes> nike = new ArrayList<>();
    ArrayList<Shoes> vans = new ArrayList<>();
    ArrayList<Shoes> shoesInfoTemp = new ArrayList<>();
    ArrayList<Shoes> shoesAdidasTemp = new ArrayList<>();
    ArrayList<Shoes> shoesNikeTemp = new ArrayList<>();
    ArrayList<Shoes> shoesVansTemp = new ArrayList<>();

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        shoesInfo.add(new Shoes("Adidas", R.drawable.adidas_logo, R.drawable.adidas_superstar1, R.drawable.adidas_superstar2, "슈퍼스타",
                "농구화의 전설, 스트리트의 심볼, 문화적 아이콘. 50년을 관통하는 수많은 스토리로 지금까지 큰 사랑을 받고 있는 아디다스 슈퍼스타를 만나보세요. 매끈한 가죽 갑피의 클래식 러버 쉘토, 톱니 아웃라인 3-스트라이프가 다가올 미래를 위해 준비된 한결같은 아이코닉한 스타일을 선사합니다.",
                "109,000원","https://shop.adidas.co.kr/PF020401.action?PROD_CD=EG4958&NFN_ST=Y"));
        shoesInfo.add(new Shoes("Vans", R.drawable.vans_logo, R.drawable.vans_pigsuede1, R.drawable.vans_pigsuede2, "피그 스웨이드 어센틱",
                "1966년에 캘리포니아 애너하임에서 탄생한 어센틱은 오리지널 반스의 헤리티지 스타일입니다. Vans #44 Deck Shoes라는 이름으로 태어난 어센틱은 컬트적인 아이콘으로 빠르게 부상했고, 그 이후 반스의 ‘오프 더 월(Off The Wall)’ 정신을 구현해왔습니다. 심플한 레이스업 프로파일 구조의 피그 스웨이드 Authentic 어센틱 44 DX는 반스의 클래식한 로우탑 슈즈에 새로운 컬러웨이로 선보이는 견고한 스웨이드 어퍼를 결합하였습니다. 전통적인 실루엣을 활용한 이 슈즈에는 메탈 아일렛, 시그니처 고무 와플솔이 적용되었습니다.",
                "79,000원", "https://www.vans.co.kr/PRODUCT/VN0A5HZS9G51"));
        shoesInfo.add(new Shoes("Nike", R.drawable.nike_logo, R.drawable.nike_daybreak1, R.drawable.nike_daybreak2, "데이브레이크",
                "오리지널에 충실한 디자인. 1979년에 출시되었던 나이키 데이브레이크가 화려했던 과거를 재현합니다. 예전과 같은 고무 와플 밑창과 나일론 갑피로 진정한 빈티지 스타일을 즐겨보세요.",
                "119,000원", "https://www.nike.com/kr/ko_kr/t/women/fw/nike-sportswear/CK2351-101/xapj86/w-nike-dbreak"));
        shoesInfo.add(new Shoes("Adidas", R.drawable.adidas_logo, R.drawable.adidas_ozweego1, R.drawable.adidas_ozweego2, "오즈위고",
                "고민이 필요 없는 완벽한 선택. 언제 어디서나 시선을 집중시키는 아디다스 오즈위고 슈즈를 만나보세요. 1990년대와 2000년대의 레트로 스타일을 녹여낸 대담한 실루엣으로 누구보다 앞서가는 스트리트 룩을 선사합니다. EVA, 아디프린+, 아디프린의 세 가지 쿠셔닝이 결합된 충격 흡수 미드솔이 탁월한 편안함을 더해줍니다.",
                "129,000원", "https://shop.adidas.co.kr/PF020401.action?PROD_CD=FX6029&NFN_ST=Y"));
        shoesInfo.add(new Shoes("Adidas", R.drawable.adidas_logo, R.drawable.adidas_stansmith1, R.drawable.adidas_stansmith2, "스탠스미스",
                "편리한 착탈 구조와 지속 가능한 디자인. 플라스틱 폐기물을 줄이는 재활용 소재로 제작된 새로운 스탠 스미스를 만나보세요. 고무 폐기물로 제작된 100% 비건 소재를 사용하여 더 나은 세상을 위한 클래식 룩을 선사합니다. 신발끈 대신 벨크로 스트랩을 더해 간편하게 신고 벗을 수 있습니다. 동물 유래 성분과 원료를 배제하고, 고기능성 재생 소재인 프라임그린으로 만든 친환경 제품입니다.",
                "109,000원", "https://shop.adidas.co.kr/PF020401.action?PROD_CD=FX5509&NFN_ST=Y"));
        shoesInfo.add(new Shoes("Vans", R.drawable.vans_logo, R.drawable.vans_comfycush1, R.drawable.vans_comfycush2, "컴피쿠시 체커보드 슬립온",
                "Vans에서 새롭게 선보이는 기술력인 컴피쿠시 ComfyCush가 클래식 Slip-on 슬립온 실루엣에 새로운 힘을 불어넣었습니다. 구름 위를 걷는 듯한 '최고급 클래스의 편안한 착화감'을 경험해보세요! 컴피쿠시 ComfyCush 기술력으로 신발의 전체적인 형태와 고무 아웃솔을 조화롭게 몰딩하여, 편안함과 그립력 모두를 제공합니다. 특히, 고무 아웃솔은 내구성과 견인력의 밑바탕이 됩니다. 더불어, 신발 내부에는 습기를 흡수하는 안감을 적용하여, 스케이트보딩을 할 때 뿐만 아니라 일상생활에서도 편안한 착용감을 제공합니다. 새롭게 업그레이드된 6 oz 캔버스 어퍼는 설포(Tongue)의 안정감을 강화했으며, 신발 내부의 일체형 구조에 아치형 서포트 기술을 더해, 언제 어디서든 편안함을 느낄 수 있도록 해줍니다.",
                "79,000원", "https://www.vans.co.kr/PRODUCT/VN0A3WMDVO41"));
        shoesInfo.add(new Shoes("Nike", R.drawable.nike_logo, R.drawable.nike_airforce1, R.drawable.nike_airforce2, "에어포스 1 07",
                "전설적인 스타일의 재해석. 빛이 그대로 살아 있는 나이키 에어 포스 1 07 OG 농구화는 많은 사랑을 받아온 디자인에 새로운 멋을 더했습니다. 튼튼하게 스티치 처리된 오버레이와 깔끔한 마감 처리, 적당한 광택감으로 빛나는 존재감을 발휘해 보세요.",
                "129,000원", "https://www.nike.com/kr/ko_kr/t/men/fw/nike-sportswear/CW2288-111/avbt44/air-force-1-07"));
        shoesInfo.add(new Shoes("Nike", R.drawable.nike_logo, R.drawable.nike_airmax1, R.drawable.nike_airmax2, "에어맥스 97",
                "20주년을 넘어 미래로 나아가다. 나이키 에어맥스 97 남성용 신발은 에어맥스 97을 유명하게 만든 특유의 물결 라인과 반사체 파이핑, 그리고 발 전체에 적용된 맥스 에어 쿠셔닝과 같은 디테일을 그대로 간직한 디자인으로, 스니커즈 애호가들의 한결같은 사랑을 받고 있습니다.",
                "199,000원", "https://www.nike.com/kr/ko_kr/t/men/fw/nike-sportswear/921826-101/nzqc95/nike-air-max-97"));

        shoesInfo.add(new Shoes("Adidas", R.drawable.adidas_logo, R.drawable.adidas_nizza1, R.drawable.adidas_nizza2, "니짜",
                "아디다스 오리지널스가 선보이는 정통 클래식 풋웨어를 만나보세요. 농구화로 태어나 깔끔하고 캐주얼한 디자인으로 스트리트를 사로잡은 스타일 아이콘의 오리지널 룩을 담아낸 니짜 슈즈입니다. 가볍고 통기성 있는 캔버스 갑피, 고무 토 범퍼, 벌커나이즈 아웃솔로 구성되어 있습니다. 황백색 사이드월의 대비색상 폭싱 테이프가 빈티지 실루엣에 매력적인 마무리를 더해줍니다.",
                "69,000원", "https://shop.adidas.co.kr/PF020401.action?PROD_CD=CQ2332&NFN_ST=Y"));
        shoesInfo.add(new Shoes("Vans", R.drawable.vans_logo, R.drawable.vans_oldschool_platform1, R.drawable.vans_oldschool_platform2, "올드스쿨 플랫폼",
                "스타일리시한 플랫폼 아웃솔을 더한 클래식 실루엣, Old Skool 올드스쿨 플랫폼입니다. 견고한 캔버스 & 스웨이드 소재로 어퍼를 구성하고, 토캡을 강화해 내구성을 높였습니다. 카라에 패드를 덧대어 편안한 착용감을 제공합니다. Vans의 오리지널 와플 플랫폼 아웃솔이 적용되었습니다.",
                "75,000원", "https://www.vans.co.kr/PRODCUCT/VN0A3B3UY281"));


        MyAdapter myAdapter = new MyAdapter(shoesInfo);
        myRecyclerView.setAdapter(myAdapter);

        i1 = (ImageView)findViewById(R.id.call);
        i2 = (ImageView)findViewById(R.id.email);
        i3 = (ImageView)findViewById(R.id.location);
        i4 = (ImageView)findViewById(R.id.mypage);



        Intent intent = getIntent();
        String customer_id = intent.getExtras().getString("ID");

        ArrayList<String[]> cust_info = new ArrayList<String[]>();

        String[] columns = new String[]{"customer_id", "name", "phone_number"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);

        if(c != null) {
            while(c.moveToNext()) {
                String id = c.getString(0);
                String name = c.getString(1);
                String phone = c.getString(2);
                cust_info.add(new String[]{id, name, phone});
            }
        }

        ArrayList<String> info = new ArrayList<String>();
        info = get_cust(cust_info, customer_id);
        String id = info.get(0);
        String name = info.get(1);
        String phone = info.get(2);


        i1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01020451095"));
                startActivity(intent);
            }
        });

        i2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                sendEmail();
            }
        });

        i3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowMap.class);
                startActivity(intent);
            }
        });

        i4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MyPage.class);
                intent.putExtra("id", id);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });

        for(int i = 0; i < shoesInfo.size(); i++) {
            if(shoesInfo.get(i).getBrand() == "Adidas") {
                adidas.add(new Shoes(shoesInfo.get(i).getBrand(), shoesInfo.get(i).getImageLogo(), shoesInfo.get(i).getImageID1(), shoesInfo.get(i).getImageID2(), shoesInfo.get(i).getShoesName(),
                        shoesInfo.get(i).getShoesDetail(), shoesInfo.get(i).getShoesPrice(), shoesInfo.get(i).getShoesUrl()));
            }
            else if(shoesInfo.get(i).getBrand() == "Nike") {
                nike.add(new Shoes(shoesInfo.get(i).getBrand(), shoesInfo.get(i).getImageLogo(), shoesInfo.get(i).getImageID1(), shoesInfo.get(i).getImageID2(), shoesInfo.get(i).getShoesName(),
                        shoesInfo.get(i).getShoesDetail(), shoesInfo.get(i).getShoesPrice(), shoesInfo.get(i).getShoesUrl()));
            }
            else if(shoesInfo.get(i).getBrand() == "Vans") {
                vans.add(new Shoes(shoesInfo.get(i).getBrand(), shoesInfo.get(i).getImageLogo(), shoesInfo.get(i).getImageID1(), shoesInfo.get(i).getImageID2(), shoesInfo.get(i).getShoesName(),
                        shoesInfo.get(i).getShoesDetail(), shoesInfo.get(i).getShoesPrice(), shoesInfo.get(i).getShoesUrl()));
            }
        }

        fragment0 = new Fragment_0();
        fragment1 = new Fragment_1();
        fragment2 = new Fragment_2();
        fragment3 = new Fragment_3();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment0).commit();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = fragment0;
                    MyAdapter myAdapter0 = new MyAdapter(shoesInfo);
                    myRecyclerView.setAdapter(myAdapter0);
                }
                else if (position == 1){
                    selected = fragment1;
                    MyAdapter myAdapter1 = new MyAdapter(adidas);
                    myRecyclerView.setAdapter(myAdapter1);
                }
                else if (position == 2){
                    selected = fragment2;
                    MyAdapter myAdapter2 = new MyAdapter(nike);
                    myRecyclerView.setAdapter(myAdapter2);
                }
                else if (position == 3){
                    selected = fragment3;
                    MyAdapter myAdapter3 = new MyAdapter(vans);
                    myRecyclerView.setAdapter(myAdapter3);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onRefresh() {
        updateLayoutView();
        swipeRefreshLayout.setRefreshing(false);
    }

    // 당겨서 새로고침 했을 때 뷰 변경 메서드
    public void updateLayoutView(){
        finish();
        overridePendingTransition(0, 0);
        Intent intent = getIntent();
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    protected void sendEmail() {
        String[] TO = {"thuds9857@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "문의 메일");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "ICE.com에 다음과 같은 내용을 문의합니다");

        try {
            startActivity(Intent.createChooser(emailIntent, "문의 메일 보내기"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity2.this, "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);

        searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.query_hint));
        searchView.setOnQueryTextListener(queryTextListener);

        return super.onCreateOptionsMenu(menu);
    }

    private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            setContentView(R.layout.activity_main2);

            swipeRefreshLayout = findViewById(R.id.swipeLayout);
            swipeRefreshLayout.setOnRefreshListener(MainActivity2.this);

            myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
            myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this, RecyclerView.VERTICAL, false));

            shoesInfoTemp.clear();
            shoesAdidasTemp.clear();
            shoesNikeTemp.clear();
            shoesVansTemp.clear();

            search = query;

            for(int i = 0; i < shoesInfo.size(); i++) {
                if(shoesInfo.get(i).getShoesName().contains(search)){
                    shoesInfoTemp.add(new Shoes(shoesInfo.get(i).getBrand(), shoesInfo.get(i).getImageLogo(), shoesInfo.get(i).getImageID1(), shoesInfo.get(i).getImageID2(), shoesInfo.get(i).getShoesName(),
                            shoesInfo.get(i).getShoesDetail(), shoesInfo.get(i).getShoesPrice(), shoesInfo.get(i).getShoesUrl()));
                }
            }
            for(int i = 0; i < adidas.size(); i++) {
                if(adidas.get(i).getShoesName().contains(search)){
                    shoesAdidasTemp.add(new Shoes(adidas.get(i).getBrand(), adidas.get(i).getImageLogo(), adidas.get(i).getImageID1(), adidas.get(i).getImageID2(), adidas.get(i).getShoesName(),
                            adidas.get(i).getShoesDetail(), adidas.get(i).getShoesPrice(), adidas.get(i).getShoesUrl()));
                }
            }
            for(int i = 0; i < nike.size(); i++) {
                if(nike.get(i).getShoesName().contains(search)){
                    shoesNikeTemp.add(new Shoes(nike.get(i).getBrand(), nike.get(i).getImageLogo(), nike.get(i).getImageID1(), nike.get(i).getImageID2(), nike.get(i).getShoesName(),
                            nike.get(i).getShoesDetail(), nike.get(i).getShoesPrice(), nike.get(i).getShoesUrl()));
                }
            }
            for(int i = 0; i < vans.size(); i++) {
                if(vans.get(i).getShoesName().contains(search)){
                    shoesVansTemp.add(new Shoes(vans.get(i).getBrand(), vans.get(i).getImageLogo(), vans.get(i).getImageID1(), vans.get(i).getImageID2(), vans.get(i).getShoesName(),
                            vans.get(i).getShoesDetail(), vans.get(i).getShoesPrice(), vans.get(i).getShoesUrl()));
                }
            }

            while(shoesInfoTemp.size() < 3) {
                shoesInfoTemp.add(new Shoes("",0,0,0,"","","",""));
            }

            while(shoesAdidasTemp.size() < 3) {
                shoesAdidasTemp.add(new Shoes("",0,0,0,"","","",""));
            }

            while(shoesNikeTemp.size() < 3) {
                shoesNikeTemp.add(new Shoes("",0,0,0,"","","",""));
            }

            while(shoesVansTemp.size() < 3) {
                shoesVansTemp.add(new Shoes("",0,0,0,"","","",""));
            }


            MyAdapter myAdapter = new MyAdapter(shoesInfoTemp);
            myRecyclerView.setAdapter(myAdapter);

            Intent intent = getIntent();
            String customer_id = intent.getExtras().getString("ID");

            ArrayList<String[]> cust_info = new ArrayList<String[]>();

            String[] columns = new String[]{"customer_id", "name", "phone_number"};
            Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null, null, null, null);

            if(c != null) {
                while(c.moveToNext()) {
                    String id = c.getString(0);
                    String name = c.getString(1);
                    String phone = c.getString(2);
                    cust_info.add(new String[]{id, name, phone});
                }
            }

            ArrayList<String> info = new ArrayList<String>();
            info = get_cust(cust_info, customer_id);
            String id = info.get(0);
            String name = info.get(1);
            String phone = info.get(2);

            i1 = (ImageView)findViewById(R.id.call);
            i2 = (ImageView)findViewById(R.id.email);
            i3 = (ImageView)findViewById(R.id.location);
            i4 = (ImageView)findViewById(R.id.mypage);

            i1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01020451095"));
                    startActivity(intent);
                }
            });

            i2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    sendEmail();
                }
            });

            i3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ShowMap.class);
                    startActivity(intent);
                }
            });

            i4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity2.this, MyPage.class);
                    intent.putExtra("id", id);
                    intent.putExtra("name", name);
                    intent.putExtra("phone", phone);
                    startActivity(intent);
                }
            });

            TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
            tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    int position = tab.getPosition();

                    Fragment selected = null;
                    if(position == 0){
                        MyAdapter myAdapter0 = new MyAdapter(shoesInfoTemp);
                        myRecyclerView.setAdapter(myAdapter0);
                        selected = fragment0;
                    }
                    else if (position == 1){
                        MyAdapter myAdapter1 = new MyAdapter(shoesAdidasTemp);
                        myRecyclerView.setAdapter(myAdapter1);
                        selected = fragment1;
                    }
                    else if (position == 2){
                        MyAdapter myAdapter2 = new MyAdapter(shoesNikeTemp);
                        myRecyclerView.setAdapter(myAdapter2);
                        selected = fragment2;
                    }
                    else if (position == 3){
                        MyAdapter myAdapter3 = new MyAdapter(shoesVansTemp);
                        myRecyclerView.setAdapter(myAdapter3);
                        selected = fragment3;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            return false;
        }



        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    public ArrayList<String> get_cust(ArrayList<String[]> a1, String ID) {
        ArrayList<String> info = new ArrayList<String>();

        for(int i = 0; i<a1.size(); i++) {
            if(a1.get(i)[0].equals(ID)) {
                info.add(a1.get(i)[0]);
                info.add(a1.get(i)[1]);
                info.add(a1.get(i)[2]);
                return (info);
            }
        }
        return (info);
    }
}