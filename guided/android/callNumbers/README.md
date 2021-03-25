MainActivity holds a button that triggers a call

CounterResetService is started in the onCreate-Method of MainActivity -> at Application StartUp
It sets the counter to 0 all 10 minutes. The counter represents the index that is used to access a phone number from an array.
The array represents telephone numbers that are fetched from the cloud. At this moment they are hard-coded.
