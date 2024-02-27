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
import com.example.facebookfake.classes.FriendHorizotalAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatListHorizotalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatListHorizotalFragment extends Fragment implements FriendHorizotalAdapter.FriendClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Friend> lstFriendHorizontal;

    public ChatListHorizotalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatListHorizotalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatListHorizotalFragment newInstance(String param1, String param2) {
        ChatListHorizotalFragment fragment = new ChatListHorizotalFragment();
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
        View root = inflater.inflate(R.layout.fragment_chat_list_horizotal, container, false);
        FriendHorizotalAdapter adapter = new FriendHorizotalAdapter(lstFriendHorizontal,getContext(),this);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return root;
    }

    void initSampleData() {
        lstFriendHorizontal = new ArrayList<>();
        lstFriendHorizontal.add(new Friend("user111","Facebook 1","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user112","Facebook 2","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user113","Facebook 3","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user114","Facebook 4","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user115","Facebook 5","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user116","Facebook 6","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user117","Facebook 7","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user118","Facebook 8","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user119","Facebook 9","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user1110","Facebook 10","avatar_placeholder_2.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user1111","Facebook 11","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user1112","Facebook 12","avatar_placeholder_1.jpg","Let it be...","info"));
        lstFriendHorizontal.add(new Friend("user1113","Facebook 13","avatar_placeholder_1.jpg","Let it be...","info"));
    }

    @Override
    public void onFriendClick(View view, int position) {
        Intent i = new Intent(getActivity(), DetailChatActivity.class);
        i.putExtra("data_detail_key_name", lstFriendHorizontal.get(position));
        startActivity(i);
    }
}