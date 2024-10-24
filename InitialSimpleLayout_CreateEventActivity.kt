import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val etEventTitle = findViewById<EditText>(R.id.etEventTitle)
        val etEventDate = findViewById<EditText>(R.id.etEventDate)
        val btnSubmitEvent = findViewById<Button>(R.id.btnSubmitEvent)

        btnSubmitEvent.setOnClickListener {
            val title = etEventTitle.text.toString()
            val date = etEventDate.text.toString()
            if (title.isNotEmpty() && date.isNotEmpty()) {
                Toast.makeText(this, "Event Created: $title on $date", Toast.LENGTH_SHORT).show()
                finish()  // Go back to MainActivity
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
