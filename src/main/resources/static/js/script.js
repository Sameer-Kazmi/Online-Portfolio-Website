const API_URL = "http://localhost:8081/api/projects";

window.onload = function () {
    loadProjects();
};

// ----------------------
// Load Projects
// ----------------------
async function loadProjects() {

    const response = await fetch(API_URL);
    const projects = await response.json();

    let cards = "";

    projects.forEach(project => {

        cards += `
        <div class="col-md-6">
            <div class="project-card">
                <h5>${project.projectName}</h5>
                <p>${project.description}</p>
                <span class="badge bg-info text-dark">${project.category}</span>
                <p class="mt-2"><strong>Tech:</strong> ${project.technologies}</p>
                <a href="${project.projectLink}" target="_blank" class="btn btn-primary btn-sm">
                    View Project
                </a>
            </div>
        </div>
        `;

    });

    document.getElementById("projectContainer").innerHTML = cards;

}