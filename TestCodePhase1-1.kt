// Event Class
data class Event(
    var name: String,
    var date: String,
    var time: String,
    var location: String,
    var description: String,
    var guestList: MutableList<Contact> = mutableListOf()
)

// Event Manager
class EventManager {
    private val eventList: MutableList<Event> = mutableListOf()

    fun createEvent(name: String, date: String, time: String, location: String, description: String): Event {
        val event = Event(name, date, time, location, description)
        eventList.add(event)
        return event
    }

    fun editEvent(event: Event, newName: String, newDate: String, newTime: String, newLocation: String, newDescription: String) {
        event.name = newName
        event.date = newDate
        event.time = newTime
        event.location = newLocation
        event.description = newDescription
    }

    fun deleteEvent(event: Event) {
        eventList.remove(event)
    }

    fun getEventList(): List<Event> {
        return eventList
    }
}
