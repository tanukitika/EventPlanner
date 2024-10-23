// Contact Class
data class Contact(
    val name: String,
    val email: String,
    val phone: String,
    var rsvpStatus: String = "Not Responded"
)

// Contact Manager
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
