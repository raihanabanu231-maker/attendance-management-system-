document.getElementById("registerBtn")?.addEventListener("click", async () => {
  const body = {
    name: document.getElementById("name").value,
    email: document.getElementById("regEmail").value,
    password: document.getElementById("regPassword").value,
    department: document.getElementById("regDepartment").value,
    shift: document.getElementById("regShift").value,
    gender: document.getElementById("regGender").value,
    bloodGroup: document.getElementById("regBlood").value
  };

  const res = await fetch("/api/auth/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body)
  });

  const data = await res.json();
  alert("Registered! Wait for admin approval.");
});

document.getElementById("loginBtn")?.addEventListener("click", async () => {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  const res = await fetch(`/api/auth/login?email=${email}&password=${password}`);
  const user = await res.json();

  if (user && user.role === "ADMIN") {
    localStorage.setItem("adminId", user.id);
    window.location.href = "admin-dashboard.html";
  } else if (user && user.role === "EMPLOYEE") {
    localStorage.setItem("employeeId", user.id);
    localStorage.setItem("name", user.name);
    localStorage.setItem("department", user.department);
    localStorage.setItem("shift", user.shift);
    window.location.href = "employee-dashboard.html";
  } else {
    document.getElementById("msg").textContent = "Invalid credentials or not approved";
  }
});
