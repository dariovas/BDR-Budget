document.addEventListener('DOMContentLoaded', function () {
    var hasRecurrenceCheckbox = document.getElementById('hasRecurrence');
    var recurrenceAnneeMoisInput = document.getElementById('recurrenceAnneeMois');
    var recurrenceNumeroMoisInput = document.getElementById('recurrenceNumeroMois');
    var recurrenceTousLesNMoisInput = document.getElementById('recurrenceTousLesNMois');

    hasRecurrenceCheckbox.addEventListener('change', function () {
        var isChecked = hasRecurrenceCheckbox.checked;
        recurrenceAnneeMoisInput.disabled = !isChecked;
        recurrenceNumeroMoisInput.disabled = !isChecked;
        recurrenceTousLesNMoisInput.disabled = !isChecked;
    });
});