// Event Creation and Viewing UI Pseudocode

class EventUI:
    properties:
        - eventManager (instance of EventManager)

    methods:
        - displayEventForm():
            - create input fields for event name, date, time, location, description
            - provide a button to submit (createEvent) and save the event

        - submitEventForm():
            - on submit button click, collect data from the form
            - call eventManager.createEvent() with the form data
            - return confirmation or display error if necessary

        - displayEventList():
            - loop through eventManager.eventList
            - display each event’s name, date, and status
            - provide buttons for editing and deleting events

        - deleteEvent(event):
            - on delete button click, call eventManager.deleteEvent(event)
            - refresh event list after deletion

        - editEvent(event):
            - on edit button click, populate event form with current event details
            - allow user to modify details and call eventManager.editEvent(event) on save
