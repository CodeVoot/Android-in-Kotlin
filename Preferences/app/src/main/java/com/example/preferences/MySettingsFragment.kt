package com.example.preferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.preference.ListPreference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.provider.MediaStore


// it is PreferenceFragment -- host or shows settings ui defined in XML
class MySettingsFragment : PreferenceFragment(),
    // stores the data behind the scenes
    SharedPreferences.OnSharedPreferenceChangeListener{
        companion object{
            val DELETE_LIMIT = "pref_key_delete_limit"
            val LIST = "pref_key_list"
            val RINGTONE = "pref_key_ringtone"
        }

    override fun onSharedPreferenceChanged(
        sharedPreferences: SharedPreferences?,
        key: String?) {
        sharedPreferences?.run {
            when(key) {
                // Shows the saved value
                DELETE_LIMIT -> {
                    findPreference(key).summary =
                        getString(key, "") ?: "10"
                }
                // Displays the human-readable entry, not the stored value
                // Example: shows “Medium” instead of "2"
                LIST -> {
                    findPreference(key).summary =
                        (findPreference(key) as ListPreference).
                        entry
                }
                RINGTONE -> {
                    // Displays the ringtone title instead of a URI
                    val uriStr = getString(key, "") ?: ""
                    findPreference(key).summary =
                        getRingtoneName(Uri.parse(uriStr))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences)

        // Manages the preferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(activity)

        // Registers this fragment to listen for preference changes
        sharedPref.registerOnSharedPreferenceChangeListener(
            this)
        with(sharedPref) {
            findPreference(DELETE_LIMIT).summary =
                getString(DELETE_LIMIT, "10")
            findPreference(LIST).summary =
                (findPreference(LIST) as ListPreference).let {
                    val ind = Math.max(0, it.findIndexOfValue(
                        it.value))
                    resources.getStringArray(listentries)[ind]
                }
            findPreference(RINGTONE).summary =
                getRingtoneName(
                    Uri.parse(getString(RINGTONE, "") ?: ""))
        }
    }

    @SuppressLint("Range")
    fun getRingtoneName(uri:Uri):String {
        return activity.contentResolver.
        query(uri, null, null, null, null)?.let {
            it.moveToFirst()
            val res = it.getString(
                it.getColumnIndex(
                    MediaStore.MediaColumns.TITLE))
            it.close()
            res
        } ?: ""
    }


}