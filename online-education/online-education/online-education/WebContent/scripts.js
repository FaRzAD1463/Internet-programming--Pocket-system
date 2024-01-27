/**
 * 
 */
document.addEventListener('DOMContentLoaded', function() {
    var selectElement = document.querySelector('select[name="courseId"]');
    selectElement.addEventListener('change', function(event) {
        var courseId = event.target.value;
        if (courseId) {
            window.location.href = `${pageContext.request.contextPath}/materials/list/${courseId}`;
        } else {
            console.error("No courseId selected");
        }
    });
});
