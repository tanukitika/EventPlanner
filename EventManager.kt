// Event Manager Class with event editing and deletion
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
