// RSVP Manager
class RSVPManager {
    fun updateRSVP(contact: Contact, status: String) {
        contact.rsvpStatus = status
    }

    fun getRSVPStatus(contact: Contact): String {
        return contact.rsvpStatus
    }

    fun generateRSVPReport(event: Event): Map<String, Int> {
        val report = mutableMapOf("Attending" to 0, "Not Attending" to 0, "Not Responded" to 0)
        for (guest in event.guestList) {
            report[guest.rsvpStatus] = report[guest.rsvpStatus]?.plus(1) ?: 0
        }
        return report
    }
}
