// Contact Manager Pseudocode (Extended for Interaction with Event)

class ContactManager:
    properties:
        - contactList (list of contacts)

    methods:
        - addContact(contact):
            - add contact to contactList

        - removeContact(contact):
            - remove contact from contactList

        - getContact(contactName):
            - find contact by name from contactList
            - return contact

        - provideGuestList():
            - return a list of all available contacts for the Event Manager to pull from
