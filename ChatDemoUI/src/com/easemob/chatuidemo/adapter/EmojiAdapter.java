/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easemob.chatuidemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.easemob.chatuidemo.R;
import com.easemob.chatuidemo.widget.emojicon.Emojicon;

public class EmojiAdapter extends ArrayAdapter<Emojicon> {
    public EmojiAdapter(Context context, List<Emojicon> data) {
        super(context, R.layout.emojicon_item, data);
    }

    public EmojiAdapter(Context context, Emojicon[] data) {
        super(context, R.layout.emojicon_item, data);
    }

    @Override
    public int getViewTypeCount() {
    	return 2;
    }
    
    @Override
    public int getItemViewType(int position) {
    	return position == getCount() -1 ? 0 : 1;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(getItemViewType(position) == 0){
        	v = View.inflate(getContext(), R.layout.emojicon_delete_item, null);
        }else{
        	 if (v == null) {
                 v = View.inflate(getContext(), R.layout.emojicon_item, null);
                 ViewHolder holder = new ViewHolder();
                 holder.icon = (TextView) v.findViewById(R.id.emojicon_icon);
                 v.setTag(holder);
             }
             Emojicon emoji = getItem(position);
             ViewHolder holder = (ViewHolder) v.getTag();
             holder.icon.setText(emoji.getEmoji());
        }
        return v;
    }

    class ViewHolder {
        TextView icon;
    }
}