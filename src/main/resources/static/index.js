console.log("JS loaded:", window.location.origin);
fetch('/api/meta/analysis')
    .then(res => res.json())
    .then(data => {

        document.getElementById('avgLikes').textContent =
            Math.round(data['Average likes: ']);
        document.getElementById('avgComments').textContent =
            Math.round(data['Average comments: ']);
        document.getElementById('bestDay').textContent =
            data['The best day: '];


        const top3 = data['Top 3 posts by engagement: '];
        const tbody = document.getElementById('top3Body');
        top3.forEach((post, i) => {
            const engagement = post.likeCount + post.commentCount;
            tbody.innerHTML += `
                    <tr>
                        <td>${i + 1}</td>
                        <td>${post.message}</td>
                        <td>${post.likeCount}</td>
                        <td>${post.commentCount}</td>
                        <td><strong>${engagement}</strong></td>
                    </tr>
                `;
        });


        const likesByDay = data['Analysis of week: '];
        const labels = Object.keys(likesByDay);
        const values = Object.values(likesByDay);

        new Chart(document.getElementById('likesChart'), {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Total Likes',
                    data: values,
                    backgroundColor: '#1877f2',
                    borderRadius: 8
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { display: false }
                },
                scales: {
                    y: { beginAtZero: true }
                }
            }
        });
    });