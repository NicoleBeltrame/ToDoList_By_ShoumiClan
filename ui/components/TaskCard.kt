@Composable
fun TaskCard(
    task: Task,
    onCheck: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Checkbox(
                checked = task.completed,
                onCheckedChange = {
                    onCheck()
                }
            )

            Column {

                Text(
                    text = task.title
                )

                Text(
                    text = task.description
                )
            }
        }
    }
}
