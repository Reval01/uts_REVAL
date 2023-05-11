package fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uts_botnavrecview.*


class CharacterFrag : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var charArrayList: ArrayList<Characters>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvChar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharactersAdapter(charArrayList){
        val intent = Intent(context,DetailCharacterActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        charArrayList = arrayListOf<Characters>()

        image = arrayOf(
            R.drawable.anjing,
            R.drawable.ayam,
            R.drawable.beruang,
            R.drawable.harimau,
            R.drawable.jerava,
            R.drawable.kucing,
            R.drawable.landak,
            R.drawable.lumba,
            R.drawable.monyet,
            R.drawable.zebra,
        )

        title = arrayOf(
            getString(R.string.anjing),
            getString(R.string.ayam),
            getString(R.string.beruang),
            getString(R.string.harimau),
            getString(R.string.jerava),
            getString(R.string.kucing),
            getString(R.string.landak),
            getString(R.string.lumba),
            getString(R.string.monyet),
            getString(R.string.zebra),

        )
        description = arrayOf(
            getString(R.string.desc_anjing),
            getString(R.string.desc_ayam),
            getString(R.string.desc_beruang),
            getString(R.string.desc_harimau),
            getString(R.string.desc_jerava),
            getString(R.string.desc_kucing),
            getString(R.string.desc_landak),
            getString(R.string.desc_lumba),
            getString(R.string.desc_monyet),
            getString(R.string.desc_zebra),
        )

        for (i in image.indices) {
            val char = Characters(image[i], title[i], description[i])
            charArrayList.add(char)
        }

    }
}
