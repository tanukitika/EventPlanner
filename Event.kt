// Event Data Class
data class Event(
    var name: String,
    var date: String,
    var time: String,
    var location: String,
    var description: String,
    var guestList: MutableList<Contact> = mutableListOf()
)
