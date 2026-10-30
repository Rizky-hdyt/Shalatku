package com.example.shalatku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasbihScreen(
    count: Int,
    rounds: Int,
    roundSize: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    onSetRoundSize: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val targets = listOf(33, 99, 100)

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Tasbih", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(4.dp))

        Text("Completed rounds: $rounds", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            targets.forEach { target ->
                FilterChip(
                    selected = (target == roundSize),
                    onClick = { onSetRoundSize(target) },
                    label = { Text("$target") }
                )
            }
        }

        Spacer(Modifier.height(12.dp))
        Text("$count / $roundSize", style = MaterialTheme.typography.displayLarge)
        Spacer(Modifier.height(16.dp))

        Button(onClick = onIncrement) {
            Text("+1")
        }

        Spacer(Modifier.height(8.dp))

        OutlinedButton(onClick = onReset) {
            Text("Reset")
        }

        Spacer(Modifier.height(16.dp))
    }
}