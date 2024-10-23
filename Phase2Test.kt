// RSVPStatus Enum
enum class RSVPStatus {
    PENDING,
    ATTENDING,
    NOT_ATTENDING
}

// Contact Class
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

// RSVP Manager Class
class RSVPManager {
    fun updateRSVP(contact: Contact, status: RSVPStatus) {
        contact.rsvpStatus = status
    }

    fun getRSVPStatus(contact: Contact): RSVPStatus {
        return contact.rsvpStatus
    }

    fun generateRSVPReport(event: Event): Map<RSVPStatus, Int> {
        val report: MutableMap<RSVPStatus, Int> = mutableMapOf(
            RSVPStatus.ATTENDING to 0,
            RSVPStatus.NOT_ATTENDING to 0,
            RSVPStatus.PENDING to 0
        )

        for (guest in event.guestList) {
            report[guest.rsvpStatus] = report[guest.rsvpStatus]?.plus(1) ?: 0
        }

        return report
    }
}

// Contact Manager Class (with getContactByName method added)
class ContactManager {
    private val contactList: MutableList<Contact> = mutableListOf()

    fun addContact(name: String, email: String, phone: String): Contact {
        val contact = Contact(name, email, phone)
        contactList.add(contact)
        return contact
    }

    fun getContactByName(name: String): Contact? {
        return contactList.find { it.name == name }
    }

    fun removeContact(contact: Contact) {
        contactList.remove(contact)
    }

    fun getContactList(): List<Contact> {
        return contactList
    }
}

// Event Manager Class - Now connects to Contact and RSVP Manager
class EventManager(
    private val contactManager: ContactManager,
    private val rsvpManager: RSVPManager
) {
    private val eventList: MutableList<Event> = mutableListOf()

    fun createEvent(name: String, date: String, time: String, location: String, description: String): Event {
        val event = Event(name, date, time, location, description)
        eventList.add(event)
        return event
    }

    fun addGuestToEvent(event: Event, contactName: String) {
        val contact = contactManager.getContactByName(contactName)
        if (contact != null) {
            event.guestList.add(contact)
        } else {
            println("Contact not found.")
        }
    }

    fun updateRSVPStatus(event: Event, contactName: String, status: RSVPStatus) {
        val contact = contactManager.getContactByName(contactName)
        if (contact != null) {
            rsvpManager.updateRSVP(contact, status)
        } else {
            println("Contact not found.")
        }
    }

    fun generateRSVPReport(event: Event): Map<RSVPStatus, Int> {
        return rsvpManager.generateRSVPReport(event)
    }

    fun getEventList(): List<Event> {
        return eventList
    }
}

// Main function for testing
fun main() {
    // Initialize Managers
    val contactManager = ContactManager()
    val rsvpManager = RSVPManager()
    val eventManager = EventManager(contactManager, rsvpManager)

    // Create some contacts
    contactManager.addContact("Alice", "alice@example.com", "123-456-7890")
    contactManager.addContact("Bob", "bob@example.com", "098-765-4321")

    // Create an event
    val event = eventManager.createEvent("Conference", "2024-11-15", "09:00", "Convention Center", "Tech Conference")

    // Add guests to the event from the Contact Manager
    eventManager.addGuestToEvent(event, "Alice")
    eventManager.addGuestToEvent(event, "Bob")

    // Update RSVP statuses for guests
    eventManager.updateRSVPStatus(event, "Alice", RSVPStatus.ATTENDING)
    eventManager.updateRSVPStatus(event, "Bob", RSVPStatus.NOT_ATTENDING)

    // Generate and print RSVP report for the event
    val report = eventManager.generateRSVPReport(event)
    println("RSVP Report: $report")

    // Print the event details with guests
    println("Event: ${event.name} at ${event.location} on ${event.date} at ${event.time}")
    for (guest in event.guestList) {
        println("  Guest: ${guest.name}, RSVP: ${guest.rsvpStatus}")
    }
}
