import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hellokotlin.viewModel.HomeViewModel
import com.example.hellokotlin.components.stepsConfigWallet.InitialValueStep
import com.example.hellokotlin.components.stepsConfigWallet.InvestmentTypeStep
import com.example.hellokotlin.components.stepsConfigWallet.MonthlyContributionStep
import com.example.hellokotlin.components.stepsConfigWallet.ui.InitialValueUI
import com.example.hellokotlin.components.stepsConfigWallet.ui.InvestmentTypeUI
import com.example.hellokotlin.components.stepsConfigWallet.ui.MonthlyContributionUI
import com.example.hellokotlin.viewModel.WalletConfigViewModel

@Composable
fun WalletConfigScreen(
    onFinish: () -> Unit,
    homeViewModel: HomeViewModel,
    viewModel: WalletConfigViewModel = viewModel()
) {
    val step = viewModel.currentStep

    Column(modifier = Modifier.padding(24.dp)) {

        // header
        Text(
            text = "Configurar Carteira",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = step.title,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // progress indicator
        LinearProgressIndicator(
            progress = (viewModel.currentStepIndex + 1) / 3f,
            modifier = Modifier.fillMaxWidth(),
            trackColor = Color.LightGray,
        )

        Spacer(modifier = Modifier.height(32.dp))

        // steps
        when (step) {
            is InvestmentTypeStep -> InvestmentTypeUI(step, viewModel)
            is InitialValueStep -> InitialValueUI(step, viewModel)
            is MonthlyContributionStep -> MonthlyContributionUI(step, viewModel)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // buttons
        Row(modifier = Modifier.fillMaxWidth()) {

            if (viewModel.currentStepIndex > 0) {
                OutlinedButton(
                    onClick = { viewModel.previousStep() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Voltar")
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // next button or finish button
            Button(
                onClick = {
                    if (viewModel.isLastStep()) {
                        homeViewModel.updateWalletConfig(viewModel.walletConfig)
                        onFinish()
                    } else {
                        viewModel.nextStep()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(if (viewModel.isLastStep()) "Concluir" else "Próximo")
            }
        }
    }
}
