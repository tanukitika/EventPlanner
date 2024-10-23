// Contact Manager Class with search functionality
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

    fun searchContactsByName(name: String): List<Contact> {
        return contactList.filter { it.name.contains(name, ignoreCase = true) }
    }

    fun getContactList(): List<Contact> {
        return contactList
    }
}
