package com.example.thuannguyen.recyclerexpanable.custome;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thuannguyen.recyclerexpanable.R;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends ExpandableRecyclerAdapter<PeopleAdapter.PeopleListItem> {
    public static final int TYPE_PERSON = 1001;

    public PeopleAdapter(Context context) {
        super(context);
        setItems(getSampleItems());
    }

    public static class PeopleListItem extends ExpandableRecyclerAdapter.ListItem {
        public String Text;
        public String Names;
        public String Address;
        public int codes;

        public PeopleListItem(String group) {
            super(TYPE_HEADER);
            Text = group;
        }

        public PeopleListItem(String first, String last) {
            super(TYPE_PERSON);
            Names = first + " " + last;
        }

        public PeopleListItem(String address,int code) {
            super(TYPE_PERSON);
            Address = address;
            codes = code;
        }


    }

    public class HeaderViewHolder extends ExpandableRecyclerAdapter.HeaderViewHolder {
        TextView name;

        public HeaderViewHolder(View view) {
            super(view, (ImageView) view.findViewById(R.id.img_arrow));
            name = (TextView) view.findViewById(R.id.txt_header_name);
        }

        public void bind(int position) {
            super.bind(position);
            name.setText(visibleItems.get(position).Text);
        }
    }

    public class PersonViewHolder extends ExpandableRecyclerAdapter.ViewHolder {
        EditText name;
        Button delete;
        public PersonViewHolder(View view) {
            super(view);
            name = (EditText) view.findViewById(R.id.edt_description);
            delete = (Button) view.findViewById(R.id.btn_delete);
        }

        public void bind(int position) {
            name.setText(visibleItems.get(position).Names);
            delete.setOnClickListener(mMyButtonClickListener);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new HeaderViewHolder(inflate(R.layout.item_header, parent));
            case TYPE_PERSON:
            default:
                return new PersonViewHolder(inflate(R.layout.item_content, parent));
        }
    }

    @Override
    public void onBindViewHolder(ExpandableRecyclerAdapter.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                ((HeaderViewHolder) holder).bind(position);
                break;
            case TYPE_PERSON:
            default:
                ((PersonViewHolder) holder).bind(position);
                break;
        }
    }

    private List<PeopleListItem> getSampleItems() {
        List<PeopleListItem> items = new ArrayList<>();
        items.add(new PeopleListItem("Friends"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Friends"));
        items.add(new PeopleListItem("", ""));
        items.add(new PeopleListItem("Chat"));
        items.add(new PeopleListItem("AAA", "BBB"));
        items.add(new PeopleListItem("BBB", "CCC"));
        items.add(new PeopleListItem("CCC", "DDD"));
        return items;
    }

    private View.OnClickListener mMyButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "position " , Toast.LENGTH_SHORT).show();
        }
    };
}