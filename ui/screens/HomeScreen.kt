@Composable
fun HomeScreen(
    viewModel: TaskViewModel
) {

    val tasks by viewModel.tasks.collectAsState()

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(
                onClick = { }
            ) {
                Icon(Icons.Default.Add, null)
            }
        }

    ) { padding ->

        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {

            items(tasks) { task ->

                TaskCard(
                    task = task,
                    onCheck = {
                        viewModel.toggleTask(task)
                    }
                )
            }
        }
    }
}

