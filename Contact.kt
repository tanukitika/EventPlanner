// Contact Data Class
data class Contact(
    val name: String,
    val email: String,
    val phone: String,
    var rsvpStatus: RSVPStatus = RSVPStatus.PENDING
)
