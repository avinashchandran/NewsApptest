package com.news.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//public class ftab1 extends Fragment {
//
//    List<Newsmodel> postList=new ArrayList<>();
//    private RecyclerView recyclerView;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public ftab1() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ftab1.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ftab1 newInstance(String param1, String param2) {
//        ftab1 fragment = new ftab1();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        recyclerView=container.findViewById(R.id.rvNews);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setHasFixedSize(true);
//        return inflater.inflate(R.layout.fragment_ftab1, container, false);
//    }
//}

public class ftab1 extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ftab1, container, false);

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvNews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        recyclerView.setAdapter(new RandomNumListAdapter(1234));
        volleyGet();
        return view;
    }

    private void volleyGet() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait, while we load the data");
        progressDialog.show();
//        Toast.makeText(getContext(), "2",Toast.LENGTH_LONG).show();
        String url = "https://www.playerline.org/test/static-endpoint/api/newslist/0.json";
        List<Newsmodel> jsonResponses = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    progressDialog.dismiss();


//                    JSONObject jsonObject1 = new JSONObject(response);
                    JSONObject data = response.getJSONObject("data");
//                    JSONArray  returnflights = data.getJSONArray("returnflights");
//                    JSONArray  onwardflights = data.getJSONArray("onwardflights");

                    JSONArray jsonArray = data.getJSONArray("newslist");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);



                        String id = jsonObject.getString("id");
                        String pid = jsonObject.getString("pid");
                        String time = jsonObject.getString("time");
                        String time_pst = jsonObject.getString("time_pst");
                        String pname = jsonObject.getString("pname");
                        String is_favorite = jsonObject.getString("is_favorite");

                        String position = jsonObject.getString("position");
                        String title = jsonObject.getString("title");
                        String details = jsonObject.getString("details");
                        String source = jsonObject.getString("source");
                        String source_name = jsonObject.getString("source_name");
                        String source_url = jsonObject.getString("source_url");

                        String source_logo = jsonObject.getString("source_logo");
                        String hash_url = jsonObject.getString("hash_url");
                        String type = jsonObject.getString("type");
                        String player_image_url = jsonObject.getString("player_image_url");

                        jsonResponses.add(new Newsmodel(id, pid, time, time_pst, pname, is_favorite, position, title, details, source, source_name, source_url,
                                source_logo, hash_url, type, player_image_url));
                        recyclerView.setAdapter(new RecyclerViewAdapter(jsonResponses, getContext()));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
