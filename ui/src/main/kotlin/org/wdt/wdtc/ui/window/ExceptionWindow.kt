@file:Suppress("NOTHING_TO_INLINE")

package org.wdt.wdtc.ui.window

import org.wdt.wdtc.core.openapi.utils.error
import org.wdt.wdtc.core.openapi.utils.getExceptionMessage
import org.wdt.wdtc.core.openapi.utils.logmaker
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

inline fun setErrorWin(e: Throwable) {
	e.let {
		logmaker.error(it)
		setWin(it.getExceptionMessage(), "发生错误!")
	}
}

fun setWin(message: String, title: String) {
	val textArea = JTextArea().apply {
		text = message
		setCaretPosition(0)
		setCaretColor(Color.RED)
		setBackground(Color(0xEEEEEE))
		setFont(Font("JetBrains Mono", Font.ITALIC, 14))
		setSelectionColor(Color.BLACK)
		setSelectedTextColor(Color.WHITE)
		setLineWrap(true)
		setWrapStyleWord(true)
	}
	JFrame(title).apply {
		layout = BorderLayout()
		add(JScrollPane(textArea), BorderLayout.CENTER)
		setTitle(title)
		isVisible = true
		defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		setSize(1000, 500)
	}.setResizable(true)
}

inline fun tryCatching(block: () -> Unit) {
	try {
		block()
	} catch (e: Throwable) {
		setErrorWin(e)
	}
}