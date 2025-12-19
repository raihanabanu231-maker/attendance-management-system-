// Load employee list
fetch("/api/admin/employees")
  .then(res => res.json())
  .then(list => {
    const tbody = document.querySelector("#empTable tbody");
    list.forEach(e => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${e.id}</td>
        <td>${e.name}</td>
        <td>${e.email}</td>
        <td>${e.approved ? "✅" : "❌"}</td>
        <td>
          ${!e.approved ? `<button class="btn btn-success btn-sm" onclick="approve(${e.id})">Approve</button>` : ""}
          <button class="btn btn-danger btn-sm" onclick="remove(${e.id})">Delete</button>
        </td>
      `;
      tbody.appendChild(row);
    });
  });

// Approve employee
function approve(id) {
  fetch(`/api/admin/employees/${id}/approve`, { method: "PUT" })
    .then(() => location.reload());
}

// Delete employee
function remove(id) {
  fetch(`/api/admin/employees/${id}`, { method: "DELETE" })
    .then(() => location.reload());
}
