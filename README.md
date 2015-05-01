# What is this?
It is a LinearLayout that only one child view can be selected. You can implement the callback yourself.

If you click the first one:

![](/image/select1.png)

And if you click the third:

![](/image/select3.png)

# How to use?

Very simple. 

1. Clone the library, and copy SingleSelectLinearLayout.java and ITMSearchInShopSingleSelectCallback.java into your project. 
2. Implement the interface ITMSearchInShopSingleSelectCallback, and custorm the two method onItemSelected(View view) and onItemUnSelected(View view).
3. Use SingleSelectLinearLayout as LinearLayout in your XML or code.


# What's more?

You can set the default selected item index, just like:

    ((SingleSelectLinearLayout) findViewById(R.id.single_select_test)).setDefaultSelectedPosition(2).initChildClickListener(this);