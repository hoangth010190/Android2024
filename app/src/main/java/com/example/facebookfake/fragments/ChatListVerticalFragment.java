package com.example.facebookfake.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.facebookfake.DetailChatActivity;
import com.example.facebookfake.R;
import com.example.facebookfake.classes.Friend;
import com.example.facebookfake.classes.FriendVerticalAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatListVerticalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatListVerticalFragment extends Fragment implements FriendVerticalAdapter.FriendClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Friend> lstFriendVertical;

    RecyclerView recyclerViewVertical;
    public ChatListVerticalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatListVerticalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatListVerticalFragment newInstance(String param1, String param2) {
        ChatListVerticalFragment fragment = new ChatListVerticalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initSampleData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chat_list_vertical, container, false);
        // Inflate the layout for this fragment
        FriendVerticalAdapter adapter = new FriendVerticalAdapter(lstFriendVertical,getContext(),this);

        recyclerViewVertical = rootView.findViewById(R.id.recyclerView);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewVertical.setAdapter(adapter);
        return rootView;
    }

    void initSampleData() {
        lstFriendVertical = new ArrayList<>();
        lstFriendVertical.add(new Friend("user01","Nguoi Dung Facebook 1","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user02","Nguoi Dung Facebook 2","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user03","Nguoi Dung Facebook 3","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user04","Nguoi Dung Facebook 4","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user05","Nguoi Dung Facebook 5","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user06","Nguoi Dung Facebook 6","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user07","Nguoi Dung Facebook 7","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user08","Nguoi Dung Facebook 8","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user09","Nguoi Dung Facebook 9","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user010","Nguoi Dung Facebook 10","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user011","Nguoi Dung Facebook 11","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user012","Nguoi Dung Facebook 12","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendVertical.add(new Friend("user013","Nguoi Dung Facebook 13","avatar_placeholder_1.jpg","Let it be...","info"));
    }

    @Override
    public void onFriendClick(View view, int position) {
        Intent i = new Intent(getActivity(), DetailChatActivity.class);
        i.putExtra("data_detail_key_name", lstFriendVertical.get(position));
        startActivity(i);
    }
}