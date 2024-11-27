package com.example.cupcake

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LandingPage(navController: NavController) {
    // Get the current context
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Landing Page", fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Title
                Text(
                    text = "A194980_Labs",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                Button(
                    onClick = {
                        openAppByPackageName(context, "com.example.AnniversaryWish_MatrixNo_A194980", "MainActivity")
                    },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Lab 1: Anniversary Card")
                }
                Button(
                    onClick = {
                        openAppByPackageName(context, "com.example.woof", "MainActivity")
                    },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Lab 3: Woof")
                }

                Button(
                    onClick = { navController.navigate("CupcakeApp") }, // Navigates to CupcakeApp
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Lab 4: Cupcake")
                }
            }
        }
    )
}

fun openAppByPackageName(context: android.content.Context, packageName: String, activityName: String) {
    try {
        val intent = Intent()
        intent.setClassName(packageName, "$packageName.$activityName")
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "App or Activity not found", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingPage() {
    val navController = rememberNavController()
    LandingPage(navController = navController)
}
