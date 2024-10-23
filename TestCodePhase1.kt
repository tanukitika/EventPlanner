// Define RSVPStatus Enum at the top level so it's accessible everywhere
enum class RSVPStatus {
    PENDING,
    ATTENDING,
    NOT_ATTENDING
}

// Contact Class with RSVPStatus Enum
data class Contact(
    val name: String,
    val email: String,
    val phone: String,
    var rsvpStatus: RSVPStatus = RSVPStatus.PENDING
)

// Event Class
data class Event(
    var name: String,
    var date: String,
    var time: String,
    var location: String,
    var description: String,
    var guestList: MutableList<Contact> = mutableListOf()
)

// Event Manager Class
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

// Contact Manager Class
class ContactManager {
    private val contactList: MutableList<Contact> = mutableListOf()

    fun addContact(name: String, email: String, phone: String): Contact {
        val contact = Contact(name, email, phone)
        contactList.add(contact)
        return contact
    }

    fun removeContact(contact: Contact) {
        contactList.remove(contact)
    }

    fun getContactList(): List<Contact> {
        return contactList
    }
}

// RSVP Manager Class
class RSVPManager {
    fun updateRSVP(contact: Contact, status: RSVPStatus) {
        contact.rsvpStatus = status
    }

    fun getRSVPStatus(contact: Contact): RSVPStatus {
        return contact.rsvpStatus
    }

    fun generateRSVPReport(event: Event): Map<RSVPStatus, Int> {
        // Initialize report with explicit types for RSVPStatus and Int
        val report: MutableMap<RSVPStatus, Int> = mutableMapOf(
            RSVPStatus.ATTENDING to 0,
            RSVPStatus.NOT_ATTENDING to 0,
            RSVPStatus.PENDING to 0
        )

        // Update counts based on RSVP status of each guest
        for (guest in event.guestList) {
            report[guest.rsvpStatus] = report[guest.rsvpStatus]?.plus(1) ?: 0
        }

        return report
    }
}

fun main() {
    // Initialize Managers
    val eventManager = EventManager()
    val contactManager = ContactManager()
    val rsvpManager = RSVPManager()

    // Create a few contacts
    val contact1 = contactManager.addContact("Alice", "alice@example.com", "123-456-7890")
    val contact2 = contactManager.addContact("Bob", "bob@example.com", "098-765-4321")

    // Create an event
    val event = eventManager.createEvent(
        "Birthday Party",
        "2024-10-31",
        "18:00",
        "123 Main St",
        "A fun birthday bash!"
    )

    // Add contacts to the event's guest list
    event.guestList.add(contact1)
    event.guestList.add(contact2)

    // Update RSVP status
    rsvpManager.updateRSVP(contact1, RSVPStatus.ATTENDING)
    rsvpManager.updateRSVP(contact2, RSVPStatus.NOT_ATTENDING)

    // Print RSVP report
    val report = rsvpManager.generateRSVPReport(event)
    println("RSVP Report: $report")

    // List all events
    val events = eventManager.getEventList()
    for (ev in events) {
        println("Event: ${ev.name} at ${ev.location} on ${ev.date} at ${ev.time}")
        println("Description: ${ev.description}")
        println("Guests:")
        for (guest in ev.guestList) {
            println("  ${guest.name}: ${guest.rsvpStatus}")
        }
    }
}
