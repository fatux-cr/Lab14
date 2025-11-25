package com.example.lab14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.*
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight
import androidx.compose.ui.unit.sp

class QuickWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                WidgetUI()
            }
        }
    }

    @Composable
    private fun WidgetUI() {

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.background)
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "Mi Estado Rápido",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = GlanceModifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Última acción: Revisaste tu Panel",
                style = TextStyle(fontSize = 14.sp),
                modifier = GlanceModifier.padding(bottom = 16.dp)
            )

            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    text = "Abrir App",
                    onClick = actionStartActivity<MainActivity>()
                )

                Spacer(modifier = GlanceModifier.width(8.dp))

                Button(
                    text = "Ver Panel",
                    onClick = actionStartActivity<SecondActivity>()
                )
            }
        }
    }
}
