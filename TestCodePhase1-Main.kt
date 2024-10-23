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
    rsvpManager.updateRSVP(contact1, "Attending")
    rsvpManager.updateRSVP(contact2, "Not Attending")

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
