package clpal.diffutilrecylerview

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import clpal.diffutilrecylerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  var _binding: ActivityMainBinding?=null
   private val  binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = EmployeeAdapter()
        val p1 = EmployeeData("1", "Chhote ", "9560117059")
        val p2 = EmployeeData("2", "Addi ", "00000000")
        val p3 = EmployeeData("3", "Anju ", "8756804649")
        val p4 = EmployeeData("4", "Prince ", "8400845313")
        adapter.submitList(listOf(p1, p2, p3, p4))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
       Handler(Looper.getMainLooper()).postDelayed({
           val p3 = EmployeeData("3", "Anju ", "8756804649")
           //val p5 = EmployeeData("5", "Priyanka ", "945677887")
           val p5 = EmployeeData("5", "Priyanka ", "945677887")
           val p6 = EmployeeData("6", "Shailesh ", "817433577")
           val p7 = EmployeeData("7", "Nilesh ", "786866575")
           //val p7 = EmployeeData("7", "Dipesh ", "786866575")
           adapter.submitList(listOf(p3,p5,p6,p7))

       },4000)
    }
    // on destroy of view make
    // the binding reference to n
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}